package misc

object Factorial {

  def calc(x: Int): BigInt = if x <= 0 then 1 else x * calc(x - 1)

}
