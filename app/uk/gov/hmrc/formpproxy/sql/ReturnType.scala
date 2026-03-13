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

sealed trait ReturnType

case object InProgressReturns extends ReturnType

case object SubmissionReturns extends ReturnType

case object DueForDeletionReturns extends ReturnType

object ReturnType {
  def getReturnIdRangeStart(returnType: ReturnType): Int =
    returnType match {
      case InProgressReturns     =>
        10001
      case SubmissionReturns     =>
        20001
      case DueForDeletionReturns =>
        20001
      case _                     =>
        throw new Exception(s"Not supported returnType: $returnType")
    }

  def getReturnAgentIdRangeStart(returnType: ReturnType): Int =
    returnType match {
      case InProgressReturns     =>
        30001
      case SubmissionReturns     =>
        50001
      case DueForDeletionReturns =>
        70001
      case _                     =>
        throw new Exception(s"Not supported returnType: $returnType")
    }

  def getLandStart(returnType: ReturnType): Int =
    returnType match {
      case InProgressReturns     =>
        4000
      case SubmissionReturns     =>
        5000
      case DueForDeletionReturns =>
        8000
      case _                     =>
        throw new Exception(s"Not supported returnType: $returnType")
    }

  def getPurchaserStart(returnType: ReturnType): Int =
    returnType match {
      case InProgressReturns     =>
        10001
      case SubmissionReturns     =>
        20001
      case DueForDeletionReturns =>
        40001
      case _                     =>
        throw new Exception(s"Not supported returnType: $returnType")
    }

  def getSubmittionStart(returnType: ReturnType): Int =
    returnType match {
      case InProgressReturns     =>
        900
      case SubmissionReturns     =>
        5000
      case DueForDeletionReturns =>
        9000
      case _                     =>
        throw new Exception(s"Not supported returnType: $returnType")
    }

}
