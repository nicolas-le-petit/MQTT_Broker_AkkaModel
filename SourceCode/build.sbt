ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "Implementing"
  )
val AkkaVersion = "2.6.19"
val AkkaHttpVersion = "10.2.9"
val CodecVersion = "1.11.9"
val TestVersion = "3.2.12"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "org.scodec" %% "scodec-core" % CodecVersion,
  "org.scalatest" %% "scalatest" % TestVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
  "org.scalatest" %% "scalatest-wordspec" % TestVersion % "test"
)