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

import org.apache.pekko.pattern.retry
import play.api.Logging
import slick.jdbc.OracleProfile
import uk.gov.hmrc.formpproxy.sql.Tables.profile

import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object AllTables extends Tables {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  override val profile: OracleProfile.type = slick.jdbc.OracleProfile
}

import org.apache.pekko
import org.apache.pekko.actor.ActorSystem


object OracleConnect extends App with Logging with OracleConnectBase {

  import DeleteQueries.*
  import InsertQueries.*
  import UpdateQueries.*

  //////////////////////// MAIN //////////////////////////////////////////////////////////
  val system                                    = ActorSystem("SlickClassicActorSystem")
  implicit val scheduler: pekko.actor.Scheduler = system.scheduler
  // implicit val ec: ExecutionContext             = system.executionContext

  stepRunner()

  def stepRunner(): Unit = {
    val stron: String = "STN001"

    // All Returns regardless of STORN ID would be deleted
    purgeDbStep()

    insertOrgStep(stron)

    createInProgressReturnsStep(recNumber = 75, storn = stron)

    createSubmittedReturnsStep(recNumber = 52, storn = stron)

    // TODO: <RESOLVE_POTENTIAL BUG> :: there is a potential bug in how Submitted/DueForDeletion Returns works???
    //createDueForDeletionReturnsStep(recNumber = 3, storn = stron)
    logger.info(s"EXEC:: End of script")
    system.terminate()
  }

  ////////////////////////// FUNCTION SET ////////////////////////////////////////////////

  def createDueForDeletionReturnsStep(storn: String, recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {
    // INSERT
    insertRecords(recNumber, storn, DueForDeletionReturns)

    // CREATE RELATIONSHIP BETWEEN TABLES
    postInsertUpdate(recNumber, DueForDeletionReturns)
  }

  def createSubmittedReturnsStep(storn: String, recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {
    // UPDATE: drop relationship / FK restriction before hard record delete
    // updateBeforeDeletion(recNumber, SubmissionReturns)

    // DELETION
    // deletedRecords(recNumber, SubmissionReturns)

    // INSERT
    insertRecords(recNumber, storn, SubmissionReturns)

    // CREATE RELATIONSHIP BETWEEN TABLES
    postInsertUpdate(recNumber, SubmissionReturns)
  }

  def createInProgressReturnsStep(storn: String, recNumber: Int)(implicit db: profile.backend.JdbcDatabaseDef) = {

    // val returnsStates      = Seq("ACCEPTED", "PENDING", "STARTED", "SUBMISTION", "SUBMITTED")

    // UPDATE: drop relationship / FK restriction before hard record delete
    // updateBeforeDeletion(recNumber, InProgressReturns)

    // DELETION
    // deletedRecords(recNumber, InProgressReturns)

    // INSERT
    insertRecords(recNumber, storn, InProgressReturns)

    // CREATE RELATIONSHIP BETWEEN TABLES
    postInsertUpdate(recNumber, InProgressReturns)
  }

  def purgeDbStep(): Unit = {

    logger.info("PRE_DELETION_UPDATE:: RETURNs")
    Await.result(db.run(updateReturnMainLandIdAction), 15.seconds)
    Await.result(db.run(updateReturnPurchaserIdAction), 15.seconds)

    logger.info("DELETE_ALL:: Purchaser")
    Await.result(db.run(deleteAllPurchaserAction), 15.seconds)

    logger.info("DELETE_ALL:: Submitted")
    Await.result(db.run(deleteAllSubmittedAction), 15.seconds)

    logger.info("DELETE_ALL:: Land")
    Await.result(db.run(deleteAllLandAction), 15.seconds)

    logger.info("DELETE_ALL:: ReturnAgent")
    Await.result(db.run(deleteAllReturnAgentAction), 15.seconds)

    logger.info("DELETE_ALL:: Return")
    Await.result(db.run(deleteAllReturnAction), 15.seconds)

    logger.info("DELETE_ALL:: Organisation")
    Await.result(db.run(deleteAllOrgsAction), 15.seconds)
  }

  def insertOrgStep(storn: String): Unit =
    logger.info(s"INSERT_ORG:: $storn")
    Await.result(db.run(insertOrgAction(storn)), 90.seconds)

  def updateBeforeDeletion(recNumber: Int, returnType: ReturnType)(implicit
    db: profile.backend.JdbcDatabaseDef
  ): Seq[Int] = {
    val updateReturnMainLandIdAsNullFuture =
      Future.sequence {
        for {
          id <- 1 to recNumber
        } yield updateReturnMainLandIdAsNull(id, returnType)
      }
    logger.info(s"EXEC:: updateReturnMainLandIdAsNullFuture: $returnType")

    // Unified retry :: https://pekko.apache.org/docs/pekko/1.0/futures.html
    val updateReturnMainLandIdAsNullFutureWithRetry: Future[Int] =
      retry(() => updateReturnMainLandIdAsNullFuture.map(_ => 0), attempts = 3, 5 milliseconds)

    Await.result(updateReturnMainLandIdAsNullFutureWithRetry, 120.seconds)

    val updateReturnMainPurchaserIdAsNullFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield updateReturnMainPurchaserIdAsNull(id, returnType)
    }
    logger.info(s"EXEC:: updateReturnMainPurchaserIdAsNull: $returnType")

    // Unified retry :: https://pekko.apache.org/docs/pekko/1.0/futures.html
    val updateReturnMainPurchaserIdAsNullFutureRetry =
      retry(() => updateReturnMainPurchaserIdAsNullFuture, attempts = 3, 5 milliseconds)

    Await.result(updateReturnMainPurchaserIdAsNullFutureRetry, 120.seconds)
  }

  def deletedRecords(recNumber: Int, returnType: ReturnType)(implicit db: profile.backend.JdbcDatabaseDef) =
    returnType match {
      case InProgressReturns =>
        val combinedDeletion = deletePurchaser(recNumber, returnType) andThen
          deleteMultiLand(recNumber, returnType) andThen
          agentReturnsIdToDelete(recNumber, returnType) andThen
          deleteReturns(recNumber, returnType) andThen deleteOrg

        logger.info(s"EXEC:: DeleteAll: $returnType")
        Await.result(db.run(combinedDeletion), 90.seconds)

      case SubmissionReturns =>
        val combinedDeletion =
          deleteSubmitted(recNumber, returnType) andThen deletePurchaser(recNumber, returnType) andThen
            deleteMultiLand(recNumber, returnType) andThen agentReturnsIdToDelete(recNumber, returnType) andThen
            deleteReturns(recNumber, returnType)
          // andThen deleteOrg

        logger.info(s"EXEC:: DeleteAll: $returnType")
        Await.result(db.run(combinedDeletion), 90.seconds)
    }

  def insertRecords(recNumber: Int, storn: String, returnType: ReturnType)(implicit
    db: profile.backend.JdbcDatabaseDef
  ): Unit =
    returnType match {
      case InProgressReturns =>
        val insertAllAction = insertReturnAction(recNumber, storn, returnType) andThen
          insertReturnAgent(recNumber, returnType) andThen
          insertLand(recNumber, returnType) andThen insertPurchaser(recNumber, returnType)

        logger.info(s"EXEC:: InsertAction: $returnType")
        Await.result(db.run(insertAllAction), 90.seconds)
      case SubmissionReturns =>
        val insertAllAction = // insertOrgAction andThen
          insertReturnAction(recNumber, storn, returnType) andThen
            insertReturnAgent(recNumber, returnType) andThen
            insertLand(recNumber, returnType) andThen insertPurchaser(recNumber, returnType) andThen
            insertSubmittion(recNumber, storn, returnType)

        logger.info(s"EXEC:: InsertAction: $returnType")
        Await.result(db.run(insertAllAction), 90.seconds)

      case DueForDeletionReturns =>
        val insertAllAction =
          insertReturnAction(recNumber, storn, returnType) andThen
            insertReturnAgent(recNumber, returnType) andThen
            insertLand(recNumber, returnType) andThen insertPurchaser(recNumber, returnType) andThen
            insertSubmittion(recNumber, storn, returnType)

        logger.info(s"EXEC:: InsertAction: $returnType")
        Await.result(db.run(insertAllAction), 90.seconds)

      case _ =>
        logger.info(s"EXEC:: InsertAction: EMPTY RUN: $returnType")
    }

  def postInsertUpdate(recNumber: Int, returnType: ReturnType)(implicit db: profile.backend.JdbcDatabaseDef) = {
    val updateReturnMainLandIdFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield {
          retry(() => updateReturnMainLandId(id, returnType), attempts = 5, 20 milliseconds)
      }
    }
    logger.info(s"EXEC:: updateReturnMainLandIdFuture: $returnType")

//    val updateReturnMainLandIdFutureRetry =
//      retry(() => updateReturnMainLandIdFuture, attempts = 3, 5 milliseconds)

    Await.result(updateReturnMainLandIdFuture, 120.seconds)

    val updateReturnsMainPurchaserIdFuture = Future.sequence {
      for {
        id <- 1 to recNumber
      } yield {
        retry(() => updateReturnsMainPurchaserId(id, returnType), attempts = 5, 20 milliseconds)
      }
    }

    logger.info(s"EXEC:: updateReturnsMainPurchaserId: $returnType")

//    val updateReturnsMainPurchaserIdFutureRetry =
//      retry(() => updateReturnsMainPurchaserIdFuture, attempts = 3, 5 milliseconds)

    Await.result(updateReturnsMainPurchaserIdFuture, 120.seconds)
  }

}
