import Dependencies._

ThisBuild / scalaVersion     := "2.13.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "mytest",
    libraryDependencies += scalaTest % Test,
     libraryDependencies += "org.postgresql" % "postgresql" % "42.3.3",
    libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2",
    //libraryDependencies += "org.apache.hive" % "hive-jdbc" % "2.3.5",
    libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.10",
    libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0",
  )
