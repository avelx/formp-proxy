/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.formpproxy.sql

/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import play.api.Logging
import slick.jdbc.OracleProfile

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps
import uk.gov.hmrc.formpproxy.sql.Tables.{profile, *}
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

object AllTables extends Tables {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  override val profile: OracleProfile.type = slick.jdbc.OracleProfile
}

object OracleConnect extends App with Logging {

  import InsertQueries._
  import DeleteQueries._
  import UpdateQueries._

  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  val url                                          =
    """jdbc:oracle:thin:sdlt_file_data/sdlt_file_data@
                        ( DESCRIPTION=
                          ( ADDRESS_LIST=
                            (FAILOVER=ON)
                            (LOAD_BALANCE=ON)
                            ( ADDRESS=
                              (PROTOCOL=TCP)
                              (HOST=localhost)
                              (PORT=1521)
                            )
                          )
                          (CONNECT_DATA=
                            (SERVER=DEDICATED)
                            ("SID"="xe")
                          )
                          (SECURITY=
                            (SSL_SERVER_CERT_DN="N/A")
                          )
                        )""" // connection info
  implicit val db: profile.backend.JdbcDatabaseDef = Database.forURL(url, driver = "oracle.jdbc.OracleDriver")

  // TODO: allocate different set of IDs per run for: Returns / Agents etc
  createInProgressReturns(recNumber = 217, storn = "STN001")
  createSubmittedReturns(recNumber = 187, storn = "STN001")

  def createSubmittedReturns(storn: String, recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {
    // UPDATE: drop relationship / FK restriction before hard record delete
    updateBeforeDeletion(recNumber, SubmissionReturns)

    // DELETION
    deletedRecords(recNumber, SubmissionReturns)

    // INSERT
    insertRecords(recNumber, storn, SubmissionReturns)

    // CREATE RELATIONSHIP BETWEEN TABLES
    postInsertUpdate(recNumber, SubmissionReturns)
  }

  def createInProgressReturns(storn: String, recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {

    // val returnsStates      = Seq("ACCEPTED", "PENDING", "STARTED", "SUBMISTION", "SUBMITTED")

    // UPDATE: drop relationship / FK restriction before hard record delete
    updateBeforeDeletion(recNumber, InProgressReturns)

    // DELETION
    deletedRecords(recNumber, InProgressReturns)

    // INSERT
    insertRecords(recNumber, storn, InProgressReturns)

    // CREATE RELATIONSHIP BETWEEN TABLES
    postInsertUpdate(recNumber, InProgressReturns)
  }

  def updateBeforeDeletion(recNumber: Int, returnType: ReturnType)(implicit
    db: profile.backend.JdbcDatabaseDef
  ): Seq[Int] = {
    val updateReturnMainLandIdAsNullFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainLandIdAsNull(id, returnType)
    }
    logger.info(s"EXEC:: updateReturnMainLandIdAsNullFuture: $returnType")
    Await.result(updateReturnMainLandIdAsNullFuture, 15.seconds)

    val updateReturnMainPurchaserIdAsNullFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainPurchaserIdAsNull(id, returnType)
    }
    logger.info(s"EXEC:: updateReturnMainPurchaserIdAsNull: $returnType")
    Await.result(updateReturnMainPurchaserIdAsNullFuture, 15.seconds)
  }

  def deletedRecords(recNumber: Int, returnType: ReturnType)(implicit db: profile.backend.JdbcDatabaseDef) =
    returnType match {
      case InProgressReturns =>
        val combinedDeletion = deletePurchaser(recNumber, returnType) andThen
          deleteMultiLand(recNumber, returnType) andThen
          agentReturnsIdToDelete(recNumber, returnType) andThen
          deleteReturns(recNumber, returnType) andThen deleteOrg

        logger.info(s"EXEC:: DeleteAll: $returnType")
        Await.result(db.run(combinedDeletion), 15.seconds)

      case SubmissionReturns =>
        val combinedDeletion =
          deleteSubmitted(recNumber, returnType) andThen deletePurchaser(recNumber, returnType) andThen
            deleteMultiLand(recNumber, returnType) andThen agentReturnsIdToDelete(recNumber, returnType) andThen
            deleteReturns(recNumber, returnType)
          // andThen deleteOrg

        logger.info(s"EXEC:: DeleteAll: $returnType")
        Await.result(db.run(combinedDeletion), 15.seconds)
    }

  def insertRecords(recNumber: Int, storn: String, returnType: ReturnType)(implicit
    db: profile.backend.JdbcDatabaseDef
  ): Unit =
    returnType match {
      case InProgressReturns =>
        val insertAllAction = insertOrgAction andThen
          insertReturnAction(recNumber, storn, returnType) andThen
          insertReturnAgent(recNumber, returnType) andThen
          insertLand(recNumber, returnType) andThen insertPurchaser(recNumber, returnType)

        logger.info(s"EXEC:: InsertAction: $returnType")
        Await.result(db.run(insertAllAction), 15.seconds)
      case SubmissionReturns =>
        val insertAllAction = // insertOrgAction andThen
          insertReturnAction(recNumber, storn, returnType) andThen
            insertReturnAgent(recNumber, returnType) andThen
            insertLand(recNumber, returnType) andThen insertPurchaser(recNumber, returnType) andThen
            insertSubmittion(recNumber, storn, returnType)

        logger.info(s"EXEC:: InsertAction: $returnType")
        Await.result(db.run(insertAllAction), 15.seconds)
      case _                 =>
        logger.info(s"EXEC:: InsertAction: EMPTY RUN: $returnType")
    }

  def postInsertUpdate(recNumber: Int, returnType: ReturnType)(implicit db: profile.backend.JdbcDatabaseDef) = {
    val updateReturnMainLandIdFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainLandId(id, returnType)
    }
    logger.info(s"EXEC:: updateReturnMainLandIdFuture: $returnType")
    Await.result(updateReturnMainLandIdFuture, 15.seconds)

    val updateReturnsMainPurchaserIdFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnsMainPurchaserId(id, returnType)
    }

    logger.info(s"EXEC:: updateReturnsMainPurchaserId: $returnType")
    Await.result(updateReturnsMainPurchaserIdFuture, 15.seconds)
  }

}
