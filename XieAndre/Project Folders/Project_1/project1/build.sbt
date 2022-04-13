//import Dependencies._
import sbt.Keys.libraryDependencies

ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "project1",
    //libraryDependencies += scalaTest % Test,
    libraryDependencies += "org.postgresql" % "postgresql" % "42.3.3",
    libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2",
    //libraryDependencies += "org.apache.hive" % "hive-jdbc" % "2.3.5",
    libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.10",
    libraryDependencies += "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.11.2"
  )
  


// NOTE: .settings appends certain ThisBuild / variables to the URI which makes it not work with some dependencies.
// The below dependency is an example of such behavior.
// SOURCE: https://search.maven.org/artifact/com.googlecode.lanterna/lanterna/3.1.1/jar

//libraryDependencies += "com.googlecode.lanterna" % "lanterna" % "3.1.1"
