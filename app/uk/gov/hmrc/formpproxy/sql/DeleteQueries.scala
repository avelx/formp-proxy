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

import uk.gov.hmrc.formpproxy.sql.ReturnType.{getReturnAgentIdRangeStart, getReturnIdRangeStart}
import uk.gov.hmrc.formpproxy.sql.Tables.*
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

import scala.language.postfixOps

object DeleteQueries {

  // TODO: ???
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global

  val deleteOrg = (storn: String) =>
    DBIO
      .seq(
        Tables.SdltOrganisation.filter(_.storn === storn).delete
      )
      .transactionally

  val deleteReturns = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.Return.filter(_.returnId === BigDecimal(getReturnIdRangeStart(returnType) + id)).delete)
      )
      .transactionally

  val agentReturnsIdToDelete = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id =>
            Tables.ReturnAgent
              .filter(_.returnAgentId === BigDecimal(getReturnAgentIdRangeStart(returnType) + id))
              .delete
          )
      )
      .transactionally

  val deleteMultiLand = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.Land.filter(_.returnId === BigDecimal(getReturnIdRangeStart(returnType) + id)).delete)
      )
      .transactionally

  val deletePurchaser = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.Purchaser.filter(_.returnId === BigDecimal(getReturnIdRangeStart(returnType) + id)).delete)
      )
      .transactionally

  val deleteSubmitted = (recNumber: Int, returnType: ReturnType) =>
    DBIO
      .sequence(
        (1 to recNumber)
          .map(id => Tables.Submission.filter(_.returnId === BigDecimal(getReturnIdRangeStart(returnType) + id)).delete)
      )
      .transactionally

  // DELETE ALL
  val updateReturnMainLandIdAction =
    for {
      returnIds <- Tables.Return.map(_.returnId).result
      _         <- DBIO
                     .sequence(
                       returnIds.map(id => Tables.Return.filter(_.returnId === id).map(_.mainLandId).update(None))
                     )
                     .transactionally
    } yield ()

  val updateReturnPurchaserIdAction =
    for {
      returnIds <- Tables.Return.map(_.returnId).result
      _         <- DBIO
                     .sequence(
                       returnIds.map(id => Tables.Return.filter(_.returnId === id).map(_.mainPurchaserId).update(None))
                     )
                     .transactionally
    } yield ()

  val deleteAllPurchaserAction =
    for {
      purchaserIds <- Tables.Purchaser.map(_.purchaserId).result
      _            <- DBIO
                        .sequence(
                          purchaserIds
                            .map(id => Tables.Purchaser.filter(_.purchaserId === id).delete)
                        )
                        .transactionally
    } yield ()

  val deleteAllSubmittedAction =
    for {
      submissionIds <- Tables.Submission.map(_.submissionId).result
      _             <- DBIO
                         .sequence(
                           submissionIds
                             .map(id => Tables.Submission.filter(_.submissionId === id).delete)
                         )
                         .transactionally
    } yield ()

  val deleteAllLandAction =
    for {
      submissionIds <- Tables.Land.map(_.landId).result
      _             <- DBIO
                         .sequence(
                           submissionIds
                             .map(id => Tables.Land.filter(_.landId === id).delete)
                         )
                         .transactionally
    } yield ()

  val deleteAllReturnAgentAction =
    for {
      submissionIds <- Tables.ReturnAgent.map(_.returnAgentId).result
      _             <- DBIO
                         .sequence(
                           submissionIds
                             .map(id => Tables.ReturnAgent.filter(_.returnAgentId === id).delete)
                         )
                         .transactionally
    } yield ()

  val deleteAllReturnAction =
    for {
      submissionIds <- Tables.Return.map(_.returnId).result
      _             <- DBIO
                         .sequence(
                           submissionIds
                             .map(id => Tables.Return.filter(_.returnId === id).delete)
                         )
                         .transactionally
    } yield ()

  val deleteAllOrgsAction =
    for {
      submissionIds <- Tables.SdltOrganisation.map(_.storn).result
      _             <- DBIO
                         .sequence(
                           submissionIds
                             .map(id => Tables.SdltOrganisation.filter(_.storn === id).delete)
                         )
                         .transactionally
    } yield ()

}
