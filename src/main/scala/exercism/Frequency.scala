package exercism

import scala.concurrent.{ExecutionContext, Future, Await}
import java.util.concurrent.Executors
import scala.concurrent.duration.Duration

object Frequency {
  def frequency(
      numWorkers: Int,
      texts: Seq[String]
  ): Map[Char, Int] = {
    implicit val context: ExecutionContext =
      ExecutionContext.fromExecutor(Executors.newFixedThreadPool(numWorkers))

    val future: Future[Map[Char, Int]] = Future
      .traverse(texts)(str =>
        Future(
          str.toLowerCase
            .groupMapReduce(identity)(_ => 1)(_ + _)
            .view
            .filterKeys(_.isLetter)
            .toList
        )
      )
      .map(_.flatten.groupMapReduce(_._1)(_._2)(_ + _))

    Await.result(future, Duration.Inf)
  }
}
