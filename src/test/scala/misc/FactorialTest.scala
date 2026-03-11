package misc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.BeforeAndAfterAll

class FactorialTest extends AnyFlatSpec with BeforeAndAfterAll with Matchers {

  "Factorial" should "returns 3628800 when parameter passed to calc is 10" in {
    val expected = 3628800
    val result = Factorial.calc(10)
    assert(expected == result)
  }

  "Factorial" should "returns 1 when parameter passed to calc is 0" in {
    val expected = 1
    val result = Factorial.calc(0)
    assert(expected == result)
  }

  "Factorial" should "returns 1 when parameter passed to calc is negative" in {
    val expected = 1
    val result = Factorial.calc(-10)
    assert(expected == result)
  }

}
