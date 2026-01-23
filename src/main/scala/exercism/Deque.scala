package exercism

import scala.collection.mutable.ArrayDeque

class Deque[A] {
  private var xs = new ArrayDeque[A]()

  def push(element: A) = xs.append(element)

  def pop: Option[A] = {
    val last = xs.lastOption
    if (last.isDefined) {
      xs = xs.init
    }
    last
  }

  def shift: Option[A] = {
    val head = xs.headOption
    if (head.isDefined) {
      xs = xs.tail
    }
    head
  }

  def unshift(element: A) = xs.prepend(element)
}
