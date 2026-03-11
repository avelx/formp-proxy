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

  val recNumber: Int = 100

  val deleteOrg = DBIO
    .seq(
      Tables.SdltOrganisation.filter(_.storn === "STN001").delete
    )
    .transactionally

  // val returnsStates      = Seq("ACCEPTED", "PENDING", "STARTED", "SUBMISTION", "SUBMITTED")

  val multipleReturnRows: Seq[ReturnRow] = (1 to recNumber)
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
        status =
          "STARTED", // returnsStates(Random.nextInt(returnsStates.length)), // ant of these accepted for In-Progress Ret
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

  val deleteReturns =
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.Return.filter(_.returnId === BigDecimal(10001 + id)).delete)
      )
      .transactionally

  val multipleAgentReturns = (1 to recNumber).map(id =>
    ReturnAgentRow(
      returnAgentId = BigDecimal(30001 + id),
      returnId = Some(BigDecimal(10001 + id)),
      agentType = "PURCHASER",
      name = Some("FoxAgencyy"),
      houseNumber = Some("num 18"),
      address1 = Some("Address Line" + id),
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

  val agentReturnsIdToDelete =
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.ReturnAgent.filter(_.returnAgentId === BigDecimal(30001 + id)).delete)
      )
      .transactionally

  val insertReturnAgent = DBIO
    .seq(
      Tables.ReturnAgent ++=
        multipleAgentReturns
    )
    .transactionally

//  val deleteLand = DBIO
//    .seq(
//      Tables.Land.filter(_.landId === BigDecimal(4000)).delete
//    )
//    .transactionally
  val deleteMultiLand = DBIO
    .sequence(
      (1 to recNumber)
        .map(id => Tables.Land.filter(_.returnId === BigDecimal(10001 + id)).delete)
    )
    .transactionally

  val insertMultiLand = (1 to recNumber).map(id =>
    LandRow(
      landId = BigDecimal(4000 + id),
      returnId = BigDecimal(10001 + id),
      propertyType = None,
      interestTransferredCreated = None,
      houseNumber = Some("houseNumber" + id), // inject House number randomisation
      address1 = Some("Address" + id),
      address2 = Some("Address" + id),
      address3 = None,
      address4 = None,
      postcode = None,
      landArea = None,
      areaUnit = None,
      localAuthorityNumber = None,
      mineralRights = None,
      nlpgUprn = None,
      willSendPlanByPost = None,
      titleNumber = None,
      landResourceRef = None,
      nextLandId = None,
      lMigrated = None,
      createDate = java.sql.Timestamp.from(Instant.now()),
      lastUpdateDate = java.sql.Timestamp.from(Instant.now())
    )
  )

  val insertLand = DBIO
    .seq(
      Tables.Land ++= insertMultiLand
    )
    .transactionally

  val multiplePurchaser = (1 to recNumber).map(id =>
    PurchaserRow(
      purchaserId = BigDecimal(10001 + id),
      returnId = BigDecimal(10001 + id),
      isCompany = None,
      isTrustee = None,
      isConnectedToVendor = None,
      isRepresentedByAgent = None,
      title = Some("Mr"),
      surname = Some("surname"),
      forename1 = Some("forename2"),
      forename2 = None,
      companyName = Some("companyName"),
      houseNumber = None,
      address1 = Some("Address 1"),
      address2 = None,
      address3 = None,
      address4 = None,
      postcode = None,
      phone = None,
      nino = None,
      purchaserResourceRef = None,
      nextPurchaserId = None,
      lMigrated = None,
      createDate = java.sql.Timestamp.from(Instant.now()),
      lastUpdateDate = java.sql.Timestamp.from(Instant.now()),
      hasNino = None,
      dateOfBirth = None,
      isUkCompany = None,
      registrationNumber = None,
      placeOfRegistration = None
    )
  )

  val insertPurchaser = DBIO
    .seq(
      Tables.Purchaser ++= multiplePurchaser
    )
    .transactionally

  val deletePurchaser =
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.Purchaser.filter(_.returnId === BigDecimal(10001 + id)).delete)
      )
      .transactionally

  val combinedDeletion =
    deletePurchaser andThen deleteMultiLand andThen agentReturnsIdToDelete andThen deleteReturns andThen deleteOrg

  /*
  ||' AND ret.main_land_id = land.land_id (+) '
 || ' AND ret.main_purchaser_id = purchaser.purchaser_id (+) '
   */

  private val combinedAction = combinedDeletion andThen
    insertOrgAction andThen
    insertReturnAction andThen
    insertReturnAgent andThen
    insertLand andThen insertPurchaser

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

}
