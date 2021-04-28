package parser

import akka.http.scaladsl.unmarshalling.Unmarshaller
import akka.http.scaladsl.model.HttpResponse

sealed trait Parser[-T]
case class SimpleParser[T](unmarshaller: Unmarshaller[HttpResponse, T], FailureStrategy: FailureStrategy[T]) extends Parser[T]

