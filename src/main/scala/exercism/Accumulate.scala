package exercism

import scala.collection.mutable.ListBuffer

class Accumulate {
  def accumulate[A, B](f: (A) => B, list: List[A]): List[B] = {
    var arr = ListBuffer.empty[B]
    list.foreach(x => {
      arr.addOne(f(x))
    })
    arr.toList
  }
}
