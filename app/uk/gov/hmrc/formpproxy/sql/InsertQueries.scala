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

import uk.gov.hmrc.formpproxy.sql.ReturnType._

import java.sql.Timestamp
import java.time.Instant
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps
import uk.gov.hmrc.formpproxy.sql.Tables.*
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

object InsertQueries {

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
  val multipleReturnRows = (recNumber: Int, storn: String, returnType: ReturnType) =>
    (1 to recNumber)
      .map(id =>
        ReturnRow(
          returnId = BigDecimal(getReturnIdRangeStart(returnType) + id),
          storn = storn,
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
          returnResourceRef = Some(BigDecimal(getReturnIdRangeStart(returnType) + id)),
          status = returnType match {
            case InProgressReturns =>
              "STARTED"
            case SubmissionReturns =>
              "SUBMITTED"
            case _                 =>
              "STARTED"
          },
          lMigrated = None,
          createDate = Timestamp(0),
          lastUpdateDate = Timestamp(0),
          declaration = None
        )
      )
      .toList

  val insertReturnAction = (recNumber: Int, storn: String, returnType: ReturnType) =>
    DBIO
      .seq(
        Tables.Return ++= multipleReturnRows(recNumber, storn, returnType)
      )
      .transactionally

  // AGENT_RETURNS
  val multipleAgentReturns = (recNumber: Int, returnType: ReturnType) =>
    (1 to recNumber).map(id =>
      ReturnAgentRow(
        returnAgentId = BigDecimal(getReturnAgentIdRangeStart(returnType) + id),
        returnId = Some(BigDecimal(getReturnIdRangeStart(returnType) + id)),
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

  val insertReturnAgent = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .seq(
        Tables.ReturnAgent ++=
          multipleAgentReturns(recNumber, returnType)
      )
      .transactionally

  // LAND
  val insertMultiLand = (recNumber: Int, returnType: ReturnType) =>
    (1 to recNumber).map(id =>
      LandRow(
        landId = BigDecimal(getLandStart(returnType) + id),
        returnId = BigDecimal(getReturnIdRangeStart(returnType) + id),
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

  val insertLand = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .seq(
        Tables.Land ++= insertMultiLand(recNumber, returnType)
      )
      .transactionally

  // PURCHASER
  val multiplePurchaser = (recNumber: Int, returnType: ReturnType) =>
    (1 to recNumber).map(id =>
      PurchaserRow(
        purchaserId = BigDecimal(getPurchaserStart(returnType) + id),
        returnId = BigDecimal(getReturnIdRangeStart(returnType) + id),
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

  val insertPurchaser = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .seq(
        Tables.Purchaser ++= multiplePurchaser(recNumber, returnType)
      )
      .transactionally

  // SUBMITTION
  val insertMultiSubmittion = (recNumber: Int, storn: String, returnType: ReturnType) =>
    (1 to recNumber).map(id =>
      SubmissionRow(
        submissionId = BigDecimal(getSubmittionStart(returnType) + id),
        returnId = BigDecimal(getReturnIdRangeStart(returnType) + id),
        storn = storn,
        submissionStatus = None,
        govtalkMessageClass = None,
        utrn = None,
        irmarkReceived = None,
        submissionReceipt = None,
        govtalkErrorCode = None,
        govtalkErrorType = None,
        govtalkErrorMessage = None,
        numPolls = None,
        acceptedDate = None,
        submittedDate = None,
        email = None,
        lMigrated = None,
        submissionRequestDate = None,
        createDate = java.sql.Timestamp.from(Instant.now()),
        lastUpdateDate = java.sql.Timestamp.from(Instant.now()),
        irMarkSent = None
      )
    )

  val insertSubmittion = (recNumber: Int, storn: String, returnType: ReturnType) =>
    DBIO
      .seq(
        Tables.Submission ++= insertMultiSubmittion(recNumber, storn, returnType)
      )
      .transactionally

}
