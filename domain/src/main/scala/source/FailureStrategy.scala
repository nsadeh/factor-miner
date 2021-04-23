package source

sealed trait FailureStrategy
case class Retry(times: Int) extends FailureStrategy
case object Complete extends FailureStrategy
