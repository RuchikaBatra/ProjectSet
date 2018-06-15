name := "MachineLearning"

version := "1"

scalaVersion := "2.11.8"

scalaSource in Compile := baseDirectory.value / "src"

// | @see https://github.com/jrudolph/sbt-dependency-graph
//net.virtualvoid.sbt.graph.Plugin.graphSettings
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "2.1.1" % "provided"