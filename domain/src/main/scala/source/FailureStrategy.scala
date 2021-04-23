package source

sealed trait FailureStrategy
case class Retry(times: Int) extends FailureStrategy
case object Complete extends FailureStrategy

object FailureStrategy {
    def retry(times: Int) = new Retry(times)
    val complete = Complete
}