package uk.gov.hmrc.formpproxy.sql

import uk.gov.hmrc.formpproxy.sql.OracleConnect.db
import uk.gov.hmrc.formpproxy.sql.Tables.*
import uk.gov.hmrc.formpproxy.sql.Tables.profile.api.*

import scala.concurrent.Future
import scala.language.postfixOps

object UpdateQueries {
  
  def updateReturnMainLandIdAsNull (id: Int) 
                                   (implicit db: profile.backend.JdbcDatabaseDef): Future[Int] = {
    Thread.sleep(100)
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainLandId)
      .update(None)
      .transactionally
    db.run(action)
  }

  def updateReturnMainPurchaserIdAsNull(id: Int)
                                       (implicit db: profile.backend.JdbcDatabaseDef): Future[Int] = {
    Thread.sleep(100)
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainPurchaserId)
      .update(None)
      .transactionally
    db.run(action)
  }

  def updateReturnMainLandId(id: Int)
                            (implicit db: profile.backend.JdbcDatabaseDef): Future[_] = {
    Thread.sleep(100)
    db.run(
      Tables.Return
        .filter(_.returnId === BigDecimal(10001 + id))
        .map(_.mainLandId)
        .update(Some(BigDecimal(4000 + id)))
        .transactionally
    )
  }

  def updateReturnsMainPurchaserId(id: Int)
                                  (implicit db: profile.backend.JdbcDatabaseDef): Future[Int] = {
    Thread.sleep(100)
    val action = Tables.Return
      .filter(_.returnId === BigDecimal(10001 + id))
      .map(_.mainPurchaserId)
      .update(Some(BigDecimal(10001 + id)))
      .transactionally
    db.run(action)
  }
  
}
