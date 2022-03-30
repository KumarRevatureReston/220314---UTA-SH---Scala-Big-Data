import Dependencies._

ThisBuild / scalaVersion     := "2.13.7"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "scalademo",
    libraryDependencies += scalaTest % Test,
    //libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3",
    //libraryDependencies += "com.h2database" % "h2" % "1.4.200",
    libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.24",
    libraryDependencies += "org.postgresql" % "postgresql" % "42.2.14"   //running version 14.2
    //libraryDependencies ++= Seq("com.typesafe.slick" %% "slick" % "3.0.0","org.slf4j" % "slf4j-nop" % "1.6.4") //this might need to hide
  )
// See  https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
