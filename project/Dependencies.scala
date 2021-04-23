import sbt._

object Dependencies {
  val akkaStreams = "com.typesafe.akka" %% "akka-stream" % Versions.akka
  val akkaStreamsTest =  "com.typesafe.akka" %% "akka-stream-testkit" % Versions.akka % Test
  val akka = "com.typesafe.akka" %% "akka-actor-typed" % Versions.akka
  val akkaHttp = "com.typesafe.akka" %% "akka-http" % Versions.akkaHttp
}

object Versions {
  val akkaHttp = "10.2.4"
  val akka = "2.6.8"
}