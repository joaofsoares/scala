package exercism

class RnaTranscription

object RnaTranscription {
  private def convertToRna(c: Char): Char = c match {
    case 'G' => 'C'
    case 'C' => 'G'
    case 'T' => 'A'
    case 'A' => 'U'
  }

  def toRna(input: String): Option[String] = Some(input.map(convertToRna))
}
