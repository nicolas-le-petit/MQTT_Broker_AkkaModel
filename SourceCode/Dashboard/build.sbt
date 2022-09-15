val PlayVersion = "2.8.16"
val Mqttv3Version = "1.2.5"
val SormVerison = "0.3.18"
val WebJarPlayVersion = "2.8.13"
val WebJarBootstrapVersion = "5.1.3"
val h2DataBaseVersion = "2.1.212"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .enablePlugins(SbtWeb)
  .settings(
    name := """Dashboard""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
      //DungTT Added
      "com.typesafe.play" %% "play" % PlayVersion,
      "org.eclipse.paho" % "org.eclipse.paho.client.mqttv3" % Mqttv3Version,
      "org.sorm-framework" % "sorm" % SormVerison,
      "org.webjars" %% "webjars-play" % WebJarPlayVersion,
      "org.webjars" % "bootstrap" % WebJarBootstrapVersion,
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
