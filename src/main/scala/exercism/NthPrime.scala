package exercism

object NthPrime {

  lazy val primes = 2 #:: LazyList.from(3, 2).filter(isPrime)

  private def isPrime(x: Int): Boolean =
    primes.takeWhile(p => p * p <= x).forall(x % _ != 0)

  def prime(n: Int): Option[Int] = {
    if n == 0 then None
    else Some(primes.take(n).last)
  }

}
