package exercism

class Grains

object Grains {

  def square(input: Int): Option[BigInt] = {
    if (input > 0 && input < 65) Some(BigInt(2).pow(input - 1)) else None
  }

  def total: BigInt = (1 to 64).flatMap(square).sum

}
