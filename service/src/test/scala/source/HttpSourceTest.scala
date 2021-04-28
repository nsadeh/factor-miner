package source


import akka.http.scaladsl.model.HttpRequest
import akka.stream.scaladsl.Sink
import akka.http.javadsl.model.HttpResponse
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.concurrent.Await
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import source.mocks.MockScheduler
import org.scalatest.flatspec.AsyncFlatSpec

object HttpSourceTest extends AnyFlatSpec with ScalaCheckPropertyChecks {
    val testHttpRequest: HttpRequest = ???
    val testFailureStrategy: FailureStrategy = FailureStrategy.log
    val testMiner: RawMiner = ???

    implicit val materializer = ???

    "A source" should "mine in correct cadence" in {
        forAll { (cadence: Cadence) =>
            val scheduler = new MockScheduler
            val stream = testMiner.get(testHttpRequest, cadence, testFailureStrategy)
            cadence match {
                case Periodic(dur) =>
                    val testDuration = dur * 10
                    val countingSink: Sink[HttpResponse,Future[Int]] = Sink.fold[Int, HttpResponse](0)((acc, _) => acc + 1)
                    val f: Future[Int] = stream.runWith(countingSink)
                    scheduler.runFor(testDuration)
                    f map { c => assert(c == 10) }
                case CronExp(cron) => ???
            }
        }
    }
     
    "A source" should "fail according to FailureStrategy" in {
        forAll { (fs: FailureStrategy) => fs match {
            case Complete => ???
            case Log => ???
            case Retry(times) => ???
        }

        }
    }
}
