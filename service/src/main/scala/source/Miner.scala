package source

import akka.http.scaladsl.model.HttpRequest
import akka.stream.scaladsl.Source
import akka.http.scaladsl.model.HttpResponse
import akka.actor.typed.ActorSystem

trait RawMiner {
  def get(request: HttpRequest, cadence: Cadence, failureStrat: FailureStrategy): Source[HttpResponse, _]
}
