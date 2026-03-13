package exercism

object SumOfMultiples {
  def sum(factors: Set[Int], limit: Int): Int = {
    val nums = for
      i <- 1 until limit
      s <- factors
      if (i % s == 0)
    yield i

    nums.toSet.sum
  }
}
