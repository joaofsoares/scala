package exercism

trait SimpleLinkedList[T] {
  def isEmpty: Boolean
  def value: T
  def add(item: T): SimpleLinkedList[T]
  def next: SimpleLinkedList[T]
  def reverse: SimpleLinkedList[T]
  def toSeq: Seq[T]
}

object SimpleLinkedList {

  def apply[T](): SimpleLinkedList[T] = new Empty[T]()

  def apply[T](params: T*): SimpleLinkedList[T] =
    params.foldLeft(SimpleLinkedList[T]())(_.add(_))

  def fromSeq[T](params: Seq[T]): SimpleLinkedList[T] = apply(params*)

}

class Empty[T] extends SimpleLinkedList[T] {
  override def isEmpty: Boolean = true
  override def add(item: T): SimpleLinkedList[T] = Node[T](item, new Empty[T])
  override def reverse: SimpleLinkedList[T] = this
  override def toSeq: Seq[T] = Seq.empty[T]
  override def value: T = ???
  override def next: SimpleLinkedList[T] = ???
}

case class Node[T](head: T, tail: SimpleLinkedList[T])
    extends SimpleLinkedList[T] {
  override def value: T = head
  override def next: SimpleLinkedList[T] = tail
  override def isEmpty: Boolean = false
  override def add(item: T): SimpleLinkedList[T] = Node[T](head, tail.add(item))
  override def reverse: SimpleLinkedList[T] = tail.reverse.add(head)
  override def toSeq: Seq[T] = head +: tail.toSeq
}
