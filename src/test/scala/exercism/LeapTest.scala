package exercism

class LeapTest extends munit.FunSuite {

  test("year not divided by 4") {
    val expected = false
    val obtained = Leap.leapYear(2015)

    assertEquals(obtained, expected)
  }

  test("year divisible by 4, not divisible by 100") {
    val expected = true
    val obtained = Leap.leapYear(1996)

    assertEquals(obtained, expected)
  }

  test("year divisible by 100, not divisible by 400") {
    val expected = false
    val obtained = Leap.leapYear(2100)

    assertEquals(obtained, expected)
  }

  test("year divisible by 400: leap year") {
    val expected = true
    val obtained = Leap.leapYear(2000)

    assertEquals(obtained, expected)
  }

}
