name := "KafkaStructured"

version := "1"

scalaVersion := "2.11.8"



scalaSource in Compile := baseDirectory.value / "src"

// | @see https://github.com/jrudolph/sbt-dependency-graph
//net.virtualvoid.sbt.graph.Plugin.graphSettings
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-8" % "2.1.1"
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.9.0.0"
libraryDependencies += "org.apache.spark" % "spark-sql-kafka-0-10" % "2.1.1"
