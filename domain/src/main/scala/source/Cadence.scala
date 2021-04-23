package source

import scala.concurrent.duration.Duration

trait Cadence
case class Periodic(dur: Duration) extends Cadence
case class CronExp() extends Cadence