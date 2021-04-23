package miner

import source.Source
import http.ActorMiner

trait Miner {
  def mine[T, PlaceHolder](source: Source[T]): akka.stream.scaladsl.Source[T, _]
}
