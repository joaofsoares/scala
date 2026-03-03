package exercism

case class Bst(input: Int, left: Option[Bst], right: Option[Bst]) {
  val value = input

  def insert(v: Int): Bst = {
    if (v <= input) {
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
}

object Bst {
  def apply(value: Int) = new Bst(value, None, None)

  def fromList(xs: List[Int]): Bst = xs.tail.foldLeft(Bst(xs.head))(_.insert(_))

  def toList(bst: Bst): List[Int] = bst.left.fold(List.empty[Int])(toList) ++
    List(bst.value) ++
    bst.right.fold(List.empty[Int])(toList)
}
