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
import uk.gov.hmrc.formpproxy.sql.Tables.*
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

object AllTables extends Tables {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  override val profile: OracleProfile.type = slick.jdbc.OracleProfile
}

object OracleConnect extends App with Logging{
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  import InsertQueries._
  import DeleteQueries._

  val url =
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
  val db  = Database.forURL(url, driver = "oracle.jdbc.OracleDriver")

  // Transactionality is required in order for OracleDb indexes work correctly
  // val returnsStates      = Seq("ACCEPTED", "PENDING", "STARTED", "SUBMISTION", "SUBMITTED")

  val combinedDeletion =
    deletePurchaser andThen deleteMultiLand andThen agentReturnsIdToDelete andThen deleteReturns andThen deleteOrg

  private val insertAllAction = insertOrgAction andThen
    insertReturnAction andThen
    insertReturnAgent andThen
    insertLand andThen insertPurchaser

  // PROCESSING LOGIC:
  // UPDATE RECORDS BEFORE DELETE / DELETE / INSERT

  def updateReturnMainLandIdAsNull(id: Int) = {
    Thread.sleep(100)
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainLandId)
      .update(None)
      .transactionally
    db.run(action)
  }

  val updateReturnMainLandIdAsNullFuture = Future.sequence {
    for {
      id <- (1 to recNumber)
    } yield updateReturnMainLandIdAsNull(id)
  }
  logger.info("EXEC:: updateReturnMainLandIdAsNullFuture")
  Await.result(updateReturnMainLandIdAsNullFuture, 61.seconds)


  def updateReturnMainPurchaserIdAsNull(id: Int) = {
    Thread.sleep(100)
    val action = Tables.Return
          .filter(_.returnId === BigDecimal(10001 + id))
          .map(_.mainPurchaserId)
          .update(None)
          .transactionally
    db.run(action)
  }

  val updateReturnMainPurchaserIdAsNullFuture = Future.sequence {
    for {
      id <- (1 to recNumber)
    } yield updateReturnMainPurchaserIdAsNull(id)
  }
  logger.info("EXEC:: updateReturnMainPurchaserIdAsNull")
  Await.result(updateReturnMainPurchaserIdAsNullFuture, 62.seconds)


  // EXEC Combined Action::
  logger.info("EXEC:: DeleteAll")
  Await.result(db.run(combinedDeletion), 63.seconds)

  // EXEC Combined Action::
  logger.info("EXEC:: InsertAction")
  Await.result(
    db.run(insertAllAction),
    60 seconds
  )

  def updateReturnMainLandId(id: Int): Future[_] = {
    Thread.sleep(100)
    db.run(
      Tables.Return
        .filter(_.returnId === BigDecimal(10001 + id))
        .map(_.mainLandId)
        .update(Some(BigDecimal(4000 + id)))
        .transactionally
    )
  }

  val updateReturnMainLandIdFuture = Future.sequence {
    for {
      id <- (1 to recNumber)
    } yield updateReturnMainLandId(id)
  }
  logger.info("EXEC:: updateReturnMainLandIdFuture")
  Await.result(updateReturnMainLandIdFuture, 102.seconds)

  def updateReturnsMainPurchaserId(id: Int) = {
    Thread.sleep(100)
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainPurchaserId)
      .update(Some(BigDecimal(10001 + id)))
      .transactionally
    db.run(action)
  }

  val updateReturnsMainPurchaserIdFuture = Future.sequence {
    for {
      id <- (1 to recNumber)
    } yield updateReturnsMainPurchaserId(id)
  }

  logger.info("EXEC:: updateReturnsMainPurchaserId")
  Await.result(updateReturnsMainPurchaserIdFuture, 101.seconds)

}