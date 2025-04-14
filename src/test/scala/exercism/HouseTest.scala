package exercism

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class HouseTest extends AnyFunSuite with Matchers {

  test("verse one - the house that jack built") {
    House.recite(1, 1) should be("""This is the house that Jack built.

""")
  }

}
