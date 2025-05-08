package exercism

class Triangle(val a: Double, val b: Double, val c: Double) {

  def equilateral: Boolean = {
    if isValid then (a == b && b == c) else false
  }

  def isosceles: Boolean = {
    if isValid then (a == b) || (a == c) || (b == c)
    else false
  }

  def scalene: Boolean = {
    if isValid then (a != b && a != c && b != c) else false
  }

  private def isValid: Boolean = {
    a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a)
  }

}
