package source

import scala.concurrent.duration.Duration
import org.quartz.CronExpression

sealed trait Cadence
case class Periodic(dur: Duration) extends Cadence
case class CronExp(cron: CronExpression) extends Cadence
