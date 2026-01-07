package exercism

import scala.collection.mutable.Map
import scala.util.boundary
import scala.util.boundary.break

class DNA(input: String) {
  def nucleotideCounts: Either[Boolean, Map[Char, Int]] = {
    var m = Map('A' -> 0, 'C' -> 0, 'G' -> 0, 'T' -> 0)
    boundary {
      for c <- input do {
        if (m.getOrElse(c, -1) != -1) m(c) += 1 else break()
      }
      return Right(m)
    }
    Left(true)
  }
}
