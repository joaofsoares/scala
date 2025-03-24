val scala3Version = "3.6.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "learn",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.scalameta" %% "munit" % "1.0.2" % Test,
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    )
  )
