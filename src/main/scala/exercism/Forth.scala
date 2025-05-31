package exercism

import scala.collection.mutable.Stack
import scala.collection.mutable.Map

class Forth extends ForthEvaluator {

  def eval(text: String): Either[ForthError, ForthEvaluatorState] = {
    evalHelper(getStr(text.toLowerCase).split(' ').toList, Stack.empty[String])
  }

  private def getStr(text: String): String = {
    val regex = ":\\s(.*?)\\s;".r
    val commands = regex.findAllMatchIn(text).toList
    val map = Map[String, String]()

    for command <- commands do {
      val commandStr = command.matched.drop(2).dropRight(2)
      val split = commandStr.split(' ').toList
      map.put(
        split.head,
        split.tail.map(g => map.getOrElse(g, g)).mkString(" ")
      )
    }

    text
      .split(';')
      .last
      .trim
      .split(' ')
      .map(c => map.getOrElse(c, c))
      .mkString(" ")
  }

  private def evalHelper(
      elements: List[String],
      stack: Stack[String]
  ): Either[ForthError, ForthEvaluatorState] = {
    (elements, stack) match {
      case (Nil, _) => Right(StrEvaluatorState(stack.reverse.mkString(" ")))
      case (x :: xs, _) if x.forall(_.isDigit) =>
        evalHelper(xs, stack.push(x))
      case (x :: xs, stack)
          if (x == "+" || x == "-" || x == "*" || x == "/" || x == "swap" || x == "over") && (stack.isEmpty || stack.length == 1) =>
        Left(ForthError(1))
      case (x :: xs, stack) if (x == "dup" || x == "drop") && stack.isEmpty =>
        Left(ForthError(1))
      case (x :: xs, stack) if x == "+" && !stack.isEmpty =>
        val first = stack.last.toInt
        val second = stack.dropRight(1).last.toInt
        evalHelper(xs, stack.dropRight(2).push((first + second).toString))
      case (x :: xs, stack) if x == "-" && !stack.isEmpty =>
        val first = stack.last.toInt
        val second = stack.dropRight(1).last.toInt
        evalHelper(xs, stack.dropRight(2).push((first - second).toString))
      case (x :: xs, stack) if x == "*" && !stack.isEmpty =>
        val first = stack.last.toInt
        val second = stack.dropRight(1).last.toInt
        evalHelper(xs, stack.dropRight(2).push((first * second).toString))
      case (x :: xs, stack) if x == "/" && !stack.isEmpty =>
        val second = stack.dropRight(1).last.toInt
        val first = stack.last.toInt

        if (first == 0 || second == 0) then {
          Left(ForthError(1))
        } else {
          evalHelper(xs, stack.dropRight(2).push((first / second).toString))
        }
      case (x :: xs, stack) if x == "dup" => {
        evalHelper(xs, stack.push(stack.head))
      }
      case (x :: xs, stack) if x == "drop" => {
        evalHelper(xs, stack.drop(1))
      }
      case (x :: xs, stack) if x == "swap" => {
        val first = stack.pop()
        val second = stack.pop()
        evalHelper(xs, stack.push(first).push(second))
      }
      case (x :: xs, stack) if x == "over" && stack.length > 1 => {
        evalHelper(xs, stack.push(stack(1)))
      }
      case _ => Left(ForthError(1))
    }
  }

}
