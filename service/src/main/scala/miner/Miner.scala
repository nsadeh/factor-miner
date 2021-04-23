package miner

import source.Source

protected trait Miner {
  def mine[T, PlaceHolder](source: Source[T]): akka.stream.scaladsl.Source[T, _]
}
