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
val PlayVersion = "2.8.16"
val Mqttv3Version = "1.2.5"
libraryDependencies ++= Seq(
  //for core
  "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "org.scodec" %% "scodec-core" % CodecVersion,
  //for web
  "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % Mqttv3Version,
  "com.typesafe.play" %% "play" % PlayVersion,
  //for testing
  "org.scalatest" %% "scalatest" % TestVersion % Test,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
  "org.scalatest" %% "scalatest-wordspec" % TestVersion % "test",
  "com.typesafe.akka" %% "akka-slf4j" % "2.6.5",
  "ch.qos.logback" % "logback-classic" % "1.2.11"
)
parallelExecution in Test := false