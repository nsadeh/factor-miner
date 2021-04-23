package source

import scala.concurrent.duration.Duration
import org.quartz.CronExpression
import scala.util.Try

sealed trait Cadence
case class Periodic(dur: Duration) extends Cadence
case class CronExp(cron: CronExpression) extends Cadence

object Cadence {
    def periodic(dur: Duration) = new Periodic(dur)
    def cron(exp: String) = Try(new CronExpression(exp))
}
