ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "slick",

    libraryDependencies ++= Seq(
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "org.slf4j" % "slf4j-nop" % "1.7.36",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
      "org.postgresql" % "postgresql" % "42.3.3"
    )
  )
