package parser

import org.slf4j.Logger

sealed trait FailureStrategy[+T]
class Recover[+T](recoverWith: =>T) extends FailureStrategy[T]
case class Log(l: Logger) extends FailureStrategy[Nothing]
case object Ignore extends FailureStrategy[Nothing]
case object Crash extends FailureStrategy[Nothing]

object FailureStrategy {
    def recoverWith[T](t: => T) = new Recover(t)
    def log(l: Logger) = new Log(l)
    val ignore = Ignore
    val crash = Crash
}