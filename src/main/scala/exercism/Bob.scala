package exercism

object Bob:
  def response(statement: String): String =
    val isQuestion = statement.trim.endsWith("?")
    val letters = statement.trim.filter(_.isLetter)
    val isYelling = if letters.isEmpty then false else letters.forall(_.isUpper)

    (isQuestion, isYelling, statement.trim.isEmpty) match {
      case (true, false, _)     => "Sure."
      case (false, true, _)     => "Whoa, chill out!"
      case (true, true, _)      => "Calm down, I know what I'm doing!"
      case (false, false, true) => "Fine. Be that way!"
      case _                    => "Whatever."
    }
