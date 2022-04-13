import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.7"

lazy val root = (project in file("."))
  .settings(
    name := "project1",

      libraryDependencies += "org.postgresql" % "postgresql" % "42.3.3",
      libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2",
      libraryDependencies += "com.github.tototoshi"%% "scala-csv" % "1.3.10"

  )
