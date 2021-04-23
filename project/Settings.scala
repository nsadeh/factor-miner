import sbt._
import sbt.Keys._
import Dependencies._

object Settings {
  val commonSettings = Seq(
    scalaVersion := "2.13.3"
  )

  val domainDependencies = Seq(
    akkaHttp
  )

  val serviceDependencies = Seq(
      akka,
      akkaHttp,
      akkaStreams,
      akkaStreamsTest
    )
}