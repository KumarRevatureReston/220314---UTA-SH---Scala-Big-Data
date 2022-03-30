name := "HelloWorldApp"
version := "0.1"
scalaVersion := "2.11.12"

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.4.3"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.4.3"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.4.3"


libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "3.3.3"  ,
 "ch.qos.logback" % "logback-classic" % "1.1.3" ,
 //"org.slf4j" % "slf4j-nop" % "1.6.4",
  //"org.apache.logging.log4j"%"log4j-slf4j-impl"%"2.11.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.3",
"org.postgresql" % "postgresql" % "9.4-1206-jdbc42" //org.postgresql.ds.PGSimpleDataSource dependency

)

libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.12"

