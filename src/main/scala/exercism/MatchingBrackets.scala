package exercism

import scala.collection.mutable.Stack

object MatchingBrackets {
  def isPaired(brackets: String): Boolean =
    val m = Map(')' -> '(', '}' -> '{', ']' -> '[')
    val stack = Stack.empty[Char]

    for c <- brackets do
      c match
        case '(' | '{' | '[' => stack.push(c)
        case ')' | '}' | ']' =>
          if stack.nonEmpty && m.get(c).get == stack.head then stack.pop
          else stack.push(c)
        case _ =>

    stack.isEmpty
}
