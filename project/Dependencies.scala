import sbt._

object Dependencies {
  val akkaStreams = "com.typesafe.akka" %% "akka-stream" % Versions.akka
  val akkaStreamsTest =  "com.typesafe.akka" %% "akka-stream-testkit" % Versions.akka % Test
  val akka = "com.typesafe.akka" %% "akka-actor-typed" % Versions.akka
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % Versions.akkaHttp
  val akkaQuartz = "com.enragedginger" %% "akka-quartz-scheduler" % Versions.akkaQuartz
  val quartz  = "org.quartz-scheduler" % "quartz" % Versions.quartz
  val scalaTest = "org.scalatest" %% "scalatest" % Versions.scalaTest % Test
  val scalaTestPlus = "org.scalatestplus" %% "scalacheck-1-15" % Versions.scalaTestPlus % Test
}

object Versions {
  val akkaHttp = "10.2.4"
  val akka = "2.6.8"
  val akkaQuartz = "1.9.0-akka-2.6.x"
  val quartz = "2.3.2"
  val scalaTest = "3.2.7"
  val scalaTestPlus = "3.2.5.0"
}