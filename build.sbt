ThisBuild / version := "0.1.0-SNAPSHOT"

 libraryDependencies +="org.scodec" %% "scodec-core" % "1.11.10"
 libraryDependencies += "com.lihaoyi" %% "upickle" % "3.1.0"
ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "scodec"
  )
