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

  // private val recNumber: Int = 100

  val deleteOrg = DBIO
    .seq(
      Tables.SdltOrganisation.filter(_.storn === "STN001").delete
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

}
