import scala.annotation.tailrec

object PrimeFactors {
  def factors(n: Long): List[Long] = {
    if n <= 1 then List() else getFactors(n, 2, List.empty[Long])
  }

  @tailrec
  private def getFactors(num: Long, divisor: Long, acc: List[Long]): List[Long] = {
    (num / divisor, num % divisor) match {
      case (1, 0) => acc :+ divisor
      case (r, 0) => getFactors(r, divisor, acc :+ divisor)
      case _ => getFactors(num, divisor + 1, acc)
    }
  }
}
