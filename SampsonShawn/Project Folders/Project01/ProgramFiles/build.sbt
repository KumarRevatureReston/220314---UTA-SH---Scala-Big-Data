ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"


lazy val scriptClasspath = Seq("*")

lazy val root = (project in file("."))
  .settings(
    name := "RevProject_1",
    //libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.2",
    libraryDependencies += "org.apache.hive" % "hive-jdbc" % "3.1.3",
    excludeDependencies ++= Seq(
    ExclusionRule( "org.slf4j", "org.slf4j" )
    ))

