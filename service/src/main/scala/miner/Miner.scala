package miner

import source.Source

trait Miner {
  def mine[T, PlaceHolder](source: Source[T]): akka.stream.scaladsl.Source[T, _]
}
