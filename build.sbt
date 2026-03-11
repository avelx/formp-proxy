import uk.gov.hmrc.DefaultBuildSettings

ThisBuild / majorVersion := 0
ThisBuild / scalaVersion := "3.3.6"
ThisBuild / scalacOptions += "-Wconf:msg=Flag.*repeatedly:s"

lazy val microservice = Project("formp-proxy", file("."))
  .enablePlugins(play.sbt.PlayScala, SbtDistributablesPlugin)
  .disablePlugins(JUnitXmlReportPlugin) //Required to prevent https://github.com/scalatest/scalatest/issues/1427
  .settings(
    PlayKeys.playDefaultPort := 6995,
    libraryDependencies ++= AppDependencies.compile ++ AppDependencies.test,
    // https://www.scala-lang.org/2021/01/12/configuring-and-suppressing-warnings.html
    // suppress warnings in generated routes files
    scalacOptions += "-Wconf:src=routes/.*:s",
  )
  .settings(CodeCoverageSettings.settings *)
  .settings(
    Compile / scalafmtOnCompile := true,
    Test / scalafmtOnCompile := true
  )

lazy val it = project
  .enablePlugins(PlayScala)
  .dependsOn(microservice % "test->test")
  .settings(DefaultBuildSettings.itSettings())
  .settings(libraryDependencies ++= AppDependencies.it)

//(Compile / sourceGenerators) += slick.taskValue

lazy val slick = taskKey[Seq[File]]("GenerateTables.scala")
slick := {
  val dir       = (Compile / sourceManaged).value
  val outputDir = dir / "slick"
  val url       =
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
  val jdbcDriver  = "oracle.jdbc.OracleDriver"
  val slickDriver = "slick.jdbc.OracleProfile"
  val pkg         = "demo"

  val cp = (Compile / dependencyClasspath).value
  val s  = streams.value

  runner.value
    .run(
      "slick.codegen.SourceCodeGenerator",
      cp.files,
      Array(slickDriver, jdbcDriver, url, outputDir.getPath, pkg),
      s.log
    )
    .failed foreach (sys error _.getMessage)

  val file = outputDir / pkg / "Tables.scala"

  Seq(file)
}