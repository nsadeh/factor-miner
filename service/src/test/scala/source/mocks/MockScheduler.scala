package source.mocks

import akka.actor.typed.Scheduler
import akka.actor.Cancellable
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.FiniteDuration
import akka.actor.Cancellable
import java.time.Duration
import scala.concurrent.ExecutionContext
import scala.collection.mutable.PriorityQueue

class MockScheduler extends Scheduler {
  private[this] var id = 0L
  private[this] var tasks = PriorityQueue[ScheduledTask]()

  def runFor(dur: FiniteDuration): Unit = while (tasks.nonEmpty && tasks.head.delay <= dur) {
    val head = tasks.dequeue()
    head.runnable.run()
    head match {
      case RepeatingTask(delay, id, runnable, interval) => tasks.enqueue(new RepeatingTask(delay + interval, id, runnable, interval))
      case _ =>
    }
  }

  override def scheduleOnce(delay: FiniteDuration, runnable: Runnable)(implicit executor: ExecutionContext): Cancellable = {
    val task = new ScheduledOnceTask(delay, id, runnable)
    id += 1
    addTask(task)
  }
  
  override def scheduleOnce(delay: Duration, runnable: Runnable, executor: ExecutionContext): Cancellable = ???
  
  override def scheduleWithFixedDelay(initialDelay: FiniteDuration, delay: FiniteDuration)(runnable: Runnable)(implicit executor: ExecutionContext): Cancellable = ???
  
  override def scheduleWithFixedDelay(initialDelay: Duration, delay: Duration, runnable: Runnable, executor: ExecutionContext): Cancellable = ???
  
  override def scheduleAtFixedRate(initialDelay: FiniteDuration, interval: FiniteDuration)(runnable: Runnable)(implicit executor: ExecutionContext): Cancellable = {
    val task = new RepeatingTask(initialDelay, id, runnable, interval)
    id += 1
    addTask(task)
  }
  
  override def scheduleAtFixedRate(initialDelay: Duration, interval: Duration, runnable: Runnable, executor: ExecutionContext): Cancellable = ???
 
  private[this] def addTask(task: ScheduledTask): Cancellable = ???
}

sealed trait ScheduledTask extends Ordered[ScheduledTask] {
    val delay: FiniteDuration
    val id: Long
    val runnable: Runnable

    override def compare(that: ScheduledTask): Int = 
      if (delay > that.delay) -1
      else if (delay < that.delay) 1
      else if (id > that.id) -1
      else if (id < that.id) 1
      else 0
  }

  case class ScheduledOnceTask(delay: FiniteDuration, id: Long, runnable: Runnable) extends ScheduledTask
  case class RepeatingTask(delay: FiniteDuration, id: Long, runnable: Runnable, interval: FiniteDuration) extends ScheduledTask
  