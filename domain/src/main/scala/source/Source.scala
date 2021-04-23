package source

import akka.http.scaladsl.model.HttpRequest
import parser.Parser

case class Source(request: HttpRequest, cadence: Cadence, failureStrat: FailureStrategy, parser: Parser)
