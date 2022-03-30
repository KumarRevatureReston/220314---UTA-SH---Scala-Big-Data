import sbt.Keys.libraryDependencies

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "Project01",
      libraryDependencies += "org.postgresql" % "postgresql" % "42.3.3",

  )
