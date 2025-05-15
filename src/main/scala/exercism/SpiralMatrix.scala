package exercism

object SpiralMatrix {

  def spiralMatrix(n: Int): List[List[Int]] = {

    var arr = Array.fill(n, n)(0)

    var top = 0
    var bottom = n - 1
    var left = 0
    var right = n - 1

    var cnt = 1

    while top <= bottom && left <= right do {
      for i <- left to right do {
        arr(top).update(i, cnt)
        cnt += 1
      }
      top += 1

      for i <- top to bottom do {
        arr(i).update(right, cnt)
        cnt += 1
      }
      right -= 1

      if top <= bottom then {
        for i <- right to left by -1 do {
          arr(bottom).update(i, cnt)
          cnt += 1
        }
        bottom -= 1
      }

      if left <= right then {
        for i <- bottom to top by -1 do {
          arr(i).update(left, cnt)
          cnt += 1
        }
        left += 1
      }
    }

    arr.map(_.toList).toList
  }
}
