package source

import org.quartz.CronExpression
import scala.util.Try
import scala.concurrent.duration.FiniteDuration

sealed trait Cadence
case class Periodic(dur: FiniteDuration) extends Cadence
case class CronExp(cron: CronExpression) extends Cadence

object Cadence {
    def periodic(dur: FiniteDuration) = new Periodic(dur)
    def cron(exp: String) = Try(new CronExpression(exp))
}
