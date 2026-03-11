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

import slick.jdbc.OracleProfile

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

import uk.gov.hmrc.formpproxy.sql.Tables.*
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

object AllTables extends Tables {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  override val profile: OracleProfile.type = slick.jdbc.OracleProfile
}

object OracleConnect extends App {
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

  val db = Database.forURL(url, driver = "oracle.jdbc.OracleDriver")

  // Transactionality is required in order for OracleDb indexes work correctly
  // val returnsStates      = Seq("ACCEPTED", "PENDING", "STARTED", "SUBMISTION", "SUBMITTED")

  val combinedDeletion =
    deletePurchaser andThen deleteMultiLand andThen agentReturnsIdToDelete andThen deleteReturns andThen deleteOrg

  private val combinedAction = combinedDeletion andThen
    insertOrgAction andThen
    insertReturnAction andThen
    insertReturnAgent andThen
    insertLand andThen insertPurchaser

  // Prepare Return Record to be DELETED
  (1 to recNumber).map(id =>
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainLandId)
      .update(None)
      .transactionally
    Await.result(
      db.run(action),
      60 seconds
    )
  )

  (1 to recNumber).map(id =>
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainPurchaserId)
      .update(None)
      .transactionally
    Await.result(
      db.run(action),
      60 seconds
    )
  )

  Await.result(
    db.run(combinedAction),
    60 seconds
  )

  (1 to recNumber).map(id =>
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainLandId)
      .update(Some(BigDecimal(4000 + id)))
      .transactionally
    Await.result(
      db.run(action),
      60 seconds
    )
  )

  (1 to recNumber).map(id =>
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainPurchaserId)
      .update(Some(BigDecimal(10001 + id)))
      .transactionally
    Await.result(
      db.run(action),
      60 seconds
    )
  )

}
