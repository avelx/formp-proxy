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

import java.sql.Timestamp
import java.time.Instant
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

import uk.gov.hmrc.formpproxy.sql.Tables.*
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

object InsertQueries {

  val recNumber: Int = 100

  // ORGANISATION
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

  // RETURNS
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
        status = "STARTED",
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

  // AGENT_RETURNS
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

  val insertReturnAgent = DBIO
    .seq(
      Tables.ReturnAgent ++=
        multipleAgentReturns
    )
    .transactionally

  // LAND
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

  // PURCHASER
  val multiplePurchaser = (1 to recNumber).map(id =>
    PurchaserRow(
      purchaserId = BigDecimal(10001 + id),
      returnId = BigDecimal(10001 + id),
      isCompany = Some("NO"),
      isTrustee = None,
      isConnectedToVendor = None,
      isRepresentedByAgent = None,
      title = Some("Mr"),
      surname = Some("surname"),
      forename1 = Some("forename2"),
      forename2 = None,
      companyName = Some("companyName"),
      houseNumber = Some("houseNumber 1"),
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
}
