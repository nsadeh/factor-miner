package source

sealed trait FailureStrategy
case class Retry(times: Int) extends FailureStrategy
case object Complete extends FailureStrategy
case object Log extends FailureStrategy

object FailureStrategy {
    def retry(times: Int) = new Retry(times)
    val complete = Complete
    val log = Log
}