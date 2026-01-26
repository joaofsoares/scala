package exercism

object RomanNumerals {
  private def romanHelper(input: Int, acc: String): String =
    if (input >= 1000) return romanHelper(input - 1000, acc + "M")
    else if (input >= 900) return romanHelper(input - 900, acc + "CM")
    else if (input >= 500) return romanHelper(input - 500, acc + "D")
    else if (input >= 400) return romanHelper(input - 400, acc + "CD")
    else if (input >= 100) return romanHelper(input - 100, acc + "C")
    else if (input >= 90) return romanHelper(input - 90, acc + "XC")
    else if (input >= 50) return romanHelper(input - 50, acc + "L")
    else if (input >= 40) return romanHelper(input - 40, acc + "XL")
    else if (input >= 10) return romanHelper(input - 10, acc + "X")
    else if (input >= 9) return romanHelper(input - 9, acc + "IX")
    else if (input >= 5) return romanHelper(input - 5, acc + "V")
    else if (input >= 4) return romanHelper(input - 4, acc + "IV")
    else if (input > 0) return romanHelper(input - 1, acc + "I")
    else acc

  def roman(input: Int): String = romanHelper(input, "")
}
