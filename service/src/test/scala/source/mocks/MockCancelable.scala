package source.mocks

import akka.actor.Cancellable

class MockCancelable(scheduler: MockScheduler, task: ScheduledTask) extends Cancellable {

  override def cancel(): Boolean = ???
  
  override def isCancelled: Boolean = ???

}
