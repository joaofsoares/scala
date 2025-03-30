package exercism

object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] =
    if dnaStrandOne.length() == dnaStrandTwo.length() then
      var cnt: Int = 0

      for i <- 0 until dnaStrandOne.length() do
        if dnaStrandOne(i) != dnaStrandTwo(i) then cnt += 1

      Some(cnt)
    else None
}
