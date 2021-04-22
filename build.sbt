import sbt._
import Settings._

lazy val `factor-miner` = Project("factor-miner",  file("."))
  .settings(commonSettings)
  .settings(organization := "trademind.io")
  .settings(moduleName := "factor-miner")
  .settings(name := "factor-miner")