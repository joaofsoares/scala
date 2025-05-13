package exercism

object PascalsTriangle {
  def rows(row: Int): List[List[Int]] = {
    if row <= 0 then List()
    else {
      var triangle: List[List[Int]] = List.empty[List[Int]]

      for i <- 0 until row do {

        val arr = (0 to i)
          .map(j => {
            if i == j || j == 0 then 1
            else triangle(i - 1)(j - 1) + triangle(i - 1)(j)
          })
          .toList

        triangle = triangle :+ arr

      }

      triangle
    }
  }
}
