package exercism

import scala.annotation.tailrec

object ArmstrongNumbers:

  def isArmstrongNumber(i: Int): Boolean = {
    val str = i.toString
    i == recur(0, str.toList, str.length)
  }

  @tailrec
  private def recur(acc: Int, ns: List[Char], s: Int): Int = {
    if ns.nonEmpty then
      recur(acc + math.pow(ns.head.asDigit, s).toInt, ns.tail, s)
    else acc
  }
