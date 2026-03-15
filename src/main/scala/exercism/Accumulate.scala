package exercism

class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] = {

    list.map(f(_))

    /* without using built in lib
    var arr = ListBuffer.empty[B]
    for element <- list do {
      arr.addOne(f(element))
    }
    arr.toList
     */

  }
}
