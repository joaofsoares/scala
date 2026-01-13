package exercism

class BinarySearch

object BinarySearch {
  def find(input: List[Int], target: Int): Option[Int] = {
    val sortedInput = input.sorted

    var start: Int = 0
    var end: Int = input.length

    while (start < end) {
      val mid = start + (end - start) / 2
      if (sortedInput(mid) == target) {
        return Some(mid)
      } else if (sortedInput(mid) < target) {
        start = mid + 1
      } else {
        end = mid
      }
    }

    None
  }
}
