package exercism

import scala.collection.mutable.ListBuffer

object SecretHandshake:
  def commands(i: Int): List[String] =
    val command = i.toBinaryString
    var result = ListBuffer[String]()
    var decimal: Int = 1

    var x = command.length - 1
    while x >= 0 do
      command(x) match {
        case '1' =>
          decimal match {
            case 1 =>
              result.addOne("wink")
            case 10 =>
              result.addOne("double blink")
            case 100 =>
              result.addOne("close your eyes")
            case 1000 =>
              result.addOne("jump")
            case _ => result = result.reverse
          }
          decimal *= 10
        case _ => decimal *= 10
      }
      x -= 1

    result.toList
