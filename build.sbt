import sbt._
import Settings._

lazy val `domain` = project
  .settings(commonSettings)
  .settings(libraryDependencies ++= domainDependencies)

lazy val `service` = project
  .settings(commonSettings)
  .settings(libraryDependencies ++= serviceDependencies)
  .dependsOn(domain)

lazy val `factor-miner` = Project("factor-miner",  file("."))
  .settings(commonSettings)
  .settings(organization := "trademind.io")
  .settings(moduleName := "factor-miner")
  .settings(name := "factor-miner")
  .aggregate(
    service,
    domain
    )