ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.0"
ThisBuild / organization     := "com.teamb"
ThisBuild / organizationName := "teamb"


lazy val kafka = Seq(
  "kafka-client" % "kafka-client" % "2.4.1" from "https://repo1.maven.org/maven2/org/apache/kafka/kafka-clients/2.4.1/kafka-clients-2.4.1.pom",
  "org.apache.kafka" %% "kafka" % "2.4.1"
)

lazy val play = Seq(
  "com.typesafe.play" %% "play-json" % "2.7.4"
)

lazy val spark = Seq(
  "org.apache.spark" %% "spark-core" % "3.2.1",
  "org.apache.spark" %% "spark-hive" % "3.2.1",
  "org.apache.spark" %% "spark-sql" % "3.2.1",
  "org.apache.spark" %% "spark-sql-kafka-0-10" % "3.2.1",
  "org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.2.1",
  "org.apache.spark" %% "spark-streaming" % "3.2.1" % "provided"

)

lazy val jdbc = Seq(
  "org.postgresql" % "postgresql" % "42.3.4"
)


lazy val root = (project in file("."))
  .settings(
    name := "RevProject_3",
    libraryDependencies ++= kafka,
    libraryDependencies ++= play,
    libraryDependencies ++= spark,
    libraryDependencies ++= jdbc
  )