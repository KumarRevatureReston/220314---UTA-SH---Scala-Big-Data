name := "SparkScalaTest"

version := "1.0"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
    "org.apache.spark" %% "spark-core" % "2.3.2",
    "org.apache.spark" %% "spark-sql" % "2.3.2",
    "org.postgresql" %% "postgresql" % "42.3.3",
    "org.apache.hive" %% "hive-jdbc" % "3.1.2",
    "com.github.tototoshi" %% "scala-csv" % "1.3.10",
)
