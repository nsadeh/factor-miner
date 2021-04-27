package source

import akka.http.scaladsl.model.HttpRequest
import parser.Parser

trait Source[+T]
case class ParsedSource[T, P >: T](request: HttpRequest, cadence: Cadence, failureStrat: FailureStrategy, parser: Parser[P]) extends Source[T]

