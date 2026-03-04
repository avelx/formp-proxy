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

import java.sql.Timestamp
import java.time.Instant
import scala.concurrent.Await
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt

object Tables extends demo.Tables {
  // or just use object demo.Tables, which is hard-wired to the driver stated during generation
  override val profile: OracleProfile.type = slick.jdbc.OracleProfile
}

import Tables.*
import Tables.profile.api.*

object OracleConnect extends App {
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
  val insertOrgAction = DBIO
    .seq(
      Tables.SdltOrganisation += SdltOrganisationRow(
        storn = "STN001",
        doNotDisplayWelcomePage = None,
        isReturnUser = None,
        agentCounter = None,
        returnCounter = None,
        version = None,
        lMigrated = None,
        createDate = java.sql.Timestamp.from(Instant.now()),
        lastUpdateDate = java.sql.Timestamp.from(Instant.now())
      )
    )
    .transactionally

  val multipleReturnRows = (1 to 10)
    .map(id =>
      ReturnRow(
        returnId = BigDecimal(10001 + id),
        storn = "STN001",
        purchaserCounter = BigDecimal(1),
        vendorCounter = BigDecimal(1),
        landCounter = BigDecimal(1),
        version = None,
        mainPurchaserId = None,
        mainVendorId = None,
        mainLandId = None,
        irmarkGenerated = None,
        landCertForEachProp = None,
        purgeDate = None,
        returnResourceRef = Some(BigDecimal(10001 + id)),
        status = "ACCEPTED", // ant of these accepted for In-Progress Ret
        lMigrated = None,
        createDate = Timestamp(0),
        lastUpdateDate = Timestamp(0),
        declaration = None
      )
    )
    .toList

  val insertReturnAction = DBIO
    .seq(
      Tables.Return ++= multipleReturnRows
    )
    .transactionally

  val multipleAgentReturns = (1 to 10).map(id =>
    ReturnAgentRow(
      returnAgentId = BigDecimal(30001 + id),
      returnId = Some(BigDecimal(10001 + id)),
      agentType = "PURCHASER",
      name = Some("FoxAgencyy"),
      houseNumber = Some("num 18"),
      address1 = Some("Address Line 1"),
      address2 = None,
      address3 = None,
      address4 = None,
      postcode = Some("SE1 2QR"),
      phone = None,
      email = None,
      dxAddress = None,
      reference = Some(s"agentRef: $id"),
      isAuthorised = None,
      lMigrated = None,
      createDate = java.sql.Timestamp.from(Instant.now()),
      lastUpdateDate = java.sql.Timestamp.from(Instant.now())
    )
  )
  val insertReturnAgent    = DBIO
    .seq(
      Tables.ReturnAgent ++=
        multipleAgentReturns
    )
    .transactionally

  val insertLand = DBIO
    .seq(
      Tables.Land += LandRow(
        landId = BigDecimal(4000),
        returnId = BigDecimal(10001 + 1),
        propertyType = None,
        interestTransferredCreated = None,
        houseNumber = None, address1 = None,
        address2 = None, address3 = None, address4 = None,
        postcode = None, landArea = None, areaUnit = None,
        localAuthorityNumber = None, mineralRights = None,
        nlpgUprn = None, willSendPlanByPost = None,
        titleNumber = None,
        landResourceRef = None,
        nextLandId = None,
        lMigrated = None,
        createDate = Timestamp(0),
        lastUpdateDate = Timestamp(0),
      )
    )
    .transactionally

  private val combinedAction = insertOrgAction andThen
    insertReturnAction andThen
    insertReturnAgent andThen
    insertLand

//  val allLandQuery = Tables.Land.filter(_.landId =!= BigDecimal(12) )
//  val deleteAllLandAction = allLandQuery.delete
//
//  val allReturnQuery = Tables.Return.filter(_.returnId =!= BigDecimal(12) )
//  val deleteAllReturnsAction = allReturnQuery.delete
//
//  val updateAllReturns = allReturnQuery.map(_.mainLandId).update(None)
  // val updateLand = allLandQuery.map(_.returnId).update(None)

//  val tranAction = {
//    for {
//      _ <- .delete
//      _ <- deleteAllReturns.delete
//    } yield ()
//  }.transactionally

  Await.result(
    db.run(combinedAction),
    60 seconds
  )

}
