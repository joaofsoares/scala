package misc

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.should.Matchers

class SumUntilNTest extends AnyFlatSpec with BeforeAndAfterAll with Matchers {

  "SumUntilN" should "returns 55 when parameter is 10" in {
    val expected = 55
    val result = SumUntilN.sum(10)
    assert(expected == result)
  }

}
