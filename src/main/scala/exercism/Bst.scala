package exercism

case class Bst[A: Ordering](
    input: A,
    left: Option[Bst[A]],
    right: Option[Bst[A]]
) {
  val value = input

  def insert(v: A): Bst[A] = {
    if (!compare(v, input)) {
      if (left.nonEmpty) {
        Bst(input, Some(left.get.insert(v)), right)
      } else {
        Bst(input, Some(Bst(v, None, None)), right)
      }
    } else {
      if (right.nonEmpty) {
        Bst(input, left, Some(right.get.insert(v)))
      } else {
        Bst(input, left, Some(Bst(v, None, None)))
      }
    }
  }

  private def compare[A: Ordering](a: A, b: A): Boolean = {
    val ord = implicitly[Ordering[A]]
    if (ord.gt(a, b)) true else false
  }
}

object Bst {
  def apply[A: Ordering](value: A) = new Bst(value, None, None)

  def fromList[A: Ordering](xs: List[A]): Bst[A] =
    xs.tail.foldLeft(Bst(xs.head))(_.insert(_))

  def toList[A: Ordering](bst: Bst[A]): List[A] =
    bst.left.fold(List.empty[A])(toList) ++
      List(bst.value) ++
      bst.right.fold(List.empty[A])(toList)
}
