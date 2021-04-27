import sbt._
import sbt.Keys._
import Dependencies._

object Settings {
  val commonSettings = Seq(
    scalaVersion := "2.13.3"
  )

  val domainDependencies = Seq(
    akkaHttp,
    quartz
  )

  val serviceDependencies = Seq(
      akka,
      akkaHttp,
      akkaStreams,
      akkaStreamsTest,
      scalaTest,
      scalaTestPlus
    )
}