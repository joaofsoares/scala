package exercism

class PhoneNumber

object PhoneNumber {
  def clean(input: Seq[Char]): Option[String] = {
    val cleaned = input.filter(c => c.isDigit)
    cleaned.length match {
      case 10 =>
        cleaned.head match {
          case '0' | '1' => None
          case _ =>
            cleaned(3) match {
              case '0' | '1' => None
              case _         => Some(cleaned.toString)
            }
        }
      case 11 =>
        cleaned.head match {
          case '1' =>
            cleaned.tail(3) match {
              case '0' | '1' => None
              case _         => Some(cleaned.tail.toString)
            }
          case _ => None
        }
      case _ => None
    }
  }
}
