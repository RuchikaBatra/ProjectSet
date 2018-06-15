name := "SparkStreaming"

version := "1"

scalaVersion := "2.11.8"


scalaSource in Compile := baseDirectory.value / "src"


libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.1.1",
  "org.apache.spark" %% "spark-sql" % "2.1.1",
  "org.apache.spark" %% "spark-mllib" % "2.1.1",
  "org.apache.spark" %% "spark-streaming" % "2.1.1",
  "org.apache.spark" %% "spark-hive" % "2.1.1"
)

libraryDependencies += "net.liftweb" %% "lift-json" % "2.6.2"

