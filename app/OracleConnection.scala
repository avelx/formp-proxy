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

import java.time.Instant
import scala.concurrent.Await
import scala.language.postfixOps
import scala.concurrent.duration.DurationInt
import scala.concurrent.ExecutionContext.Implicits.global


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

  val q = Tables.Return

//  val insert = DBIO.seq(
//    Tables.Return +=
//      ReturnRow(
//        221089801,"STN001",1,0,1,Some(0),Some(221099767),None,Some(221089856),None,None,None,Some(1),"STARTED",None,
//        java.sql.Timestamp.from(Instant.now()), java.sql.Timestamp.from(Instant.now()), None
//      )
//  )
  //val insert = Tables.Return
  //'STN001', TO_DATE('01/01/2026', 'DD/MM/YYYY'), TO_DATE('01/01/2026', 'DD/MM/YYYY')
  val insert = DBIO.seq(
    Tables.SdltOrganisation += SdltOrganisationRow(
      storn = "STN0011",
      doNotDisplayWelcomePage = None, isReturnUser = None, agentCounter = None,
      returnCounter = None, version = None, lMigrated = None, createDate = java.sql.Timestamp.from(Instant.now()),
      lastUpdateDate = java.sql.Timestamp.from(Instant.now())
      //'STN001', TO_DATE('01/01/2026', 'DD/MM/YYYY'), TO_DATE('01/01/2026',
    )
  )


  Await.result(
    for {
      x <- db.run(insert).map {result =>
        println (result)
      }
//      x <- db.run(q.result).map {result =>
//          println (result.mkString ("\n"))
//      }
    } yield x,
    5 seconds
  )
}
