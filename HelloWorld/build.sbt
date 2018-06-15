name := "Hdfstest"

version := "1"

scalaVersion := "2.11.8"


scalaSource in Compile := baseDirectory.value / "src"


libraryDependencies += "org.apache.spark" %% "spark-core" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "2.1.1" % "provided"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "2.1.1" % "provided"
libraryDependencies += "net.liftweb" %% "lift-json" % "2.6.2"

