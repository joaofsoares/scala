package exercism

import scala.collection.mutable.Map

class WordCount(input: String) {
  def countWords: Map[String, Int] = {
    val regex = raw"'([a-zA-Z0-9]+)'|([a-zA-Z0-9']+)".r

    regex
      .findAllMatchIn(input.toLowerCase)
      .flatMap { m =>
        if (m.group(1) != null) Some(m.group(1))
        else if (m.group(2) != null) Some(m.group(2))
        else None
      }
      .foldLeft(Map.empty[String, Int]) { (cnt, word) =>
        cnt + (word -> (cnt.getOrElse(word, 0) + 1))
      }

  }
}
