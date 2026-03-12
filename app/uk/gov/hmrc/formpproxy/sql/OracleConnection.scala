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

  runDataLoad(recNumber = 167, storn = "STN001")

  def runDataLoad(storn: String, recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {

    // val returnsStates      = Seq("ACCEPTED", "PENDING", "STARTED", "SUBMISTION", "SUBMITTED")

    // UPDATE: drop relationship / FK restriction before hard record delete
    updateBeforeDeletion(recNumber)

    // DELETION
    deletedRecords(recNumber)

    // INSERT
    insertRecords(recNumber, storn)

    // CREATE RELATIONSHIP BETWEEN TABLES
    postInsertUpdate(recNumber)

  }

  def updateBeforeDeletion(recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef): Seq[Int] = {
    val updateReturnMainLandIdAsNullFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainLandIdAsNull(id)
    }
    logger.info("EXEC:: updateReturnMainLandIdAsNullFuture")
    Await.result(updateReturnMainLandIdAsNullFuture, 15.seconds)

    val updateReturnMainPurchaserIdAsNullFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainPurchaserIdAsNull(id)
    }
    logger.info("EXEC:: updateReturnMainPurchaserIdAsNull")
    Await.result(updateReturnMainPurchaserIdAsNullFuture, 15.seconds)
  }

  def deletedRecords(recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {
    val combinedDeletion = deletePurchaser(recNumber) andThen deleteMultiLand(recNumber) andThen agentReturnsIdToDelete(
      recNumber
    ) andThen deleteReturns(recNumber) andThen deleteOrg

    logger.info("EXEC:: DeleteAll")
    Await.result(db.run(combinedDeletion), 15.seconds)
  }

  def insertRecords(recNumber: Int, storn: String)(implicit db: profile.backend.JdbcDatabaseDef) = {
    val insertAllAction = insertOrgAction andThen
      insertReturnAction(recNumber, storn) andThen
      insertReturnAgent(recNumber) andThen
      insertLand(recNumber) andThen insertPurchaser(recNumber)

    logger.info("EXEC:: InsertAction")
    Await.result(db.run(insertAllAction), 15.seconds)
  }

  def postInsertUpdate(recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {
    val updateReturnMainLandIdFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainLandId(id)
    }
    logger.info("EXEC:: updateReturnMainLandIdFuture")
    Await.result(updateReturnMainLandIdFuture, 15.seconds)

    val updateReturnsMainPurchaserIdFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnsMainPurchaserId(id)
    }

    logger.info("EXEC:: updateReturnsMainPurchaserId")
    Await.result(updateReturnsMainPurchaserIdFuture, 15.seconds)
  }

}
