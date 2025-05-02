package exercism

object CollatzConjecture {
  def steps(n: Int): Option[Int] = {
    if n <= 0 then None
    else stepsAcc(n, 0)
  }

  private def stepsAcc(n: Int, acc: Int): Option[Int] = {
    if n <= 1 then return Some(acc)
    else if n % 2 == 0 then return stepsAcc(n / 2, acc + 1)
    else return stepsAcc(3 * n + 1, acc + 1)
  }

}
