package exercism

enum NumberType {
  case Perfect, Abundant, Deficient
}

object PerfectNumbers {

  def classify(x: Int): Either[String, NumberType] = {

    if (x <= 0) {
      return Left("Classification is only possible for natural numbers.")
    }

    val result = (1 to x / 2).filter(n => x % n == 0).sum

    if (result == x) {
      Right(NumberType.Perfect)
    } else if (result < x) {
      Right(NumberType.Deficient)
    } else {
      Right(NumberType.Abundant)
    }
  }

}
