package http

import akka.http.scaladsl.model.HttpRequest
import source.Cadence
import source.FailureStrategy
import akka.stream.scaladsl.Source
import akka.http.scaladsl.model.HttpResponse
import akka.actor.typed.ActorSystem

trait Miner {
  def get(request: HttpRequest, cadence: Cadence, failureStrat: FailureStrategy): Source[HttpResponse, _]
}
