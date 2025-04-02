package exercism

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SecretHandshakeTest extends AnyFunSuite with Matchers {

  test("wink for 1") {
    SecretHandshake.commands(1) should be(List("wink"))
  }

  test("double blink for 10") {
    SecretHandshake.commands(2) should be(List("double blink"))
  }

  test("close your eyes for 100") {
    SecretHandshake.commands(4) should be(List("close your eyes"))
  }

  test("jump for 1000") {
    SecretHandshake.commands(8) should be(List("jump"))
  }

  test("combine two actions") {
    SecretHandshake.commands(3) should be(List("wink", "double blink"))
  }

  test("reverse two actions") {
    SecretHandshake.commands(19) should be(List("double blink", "wink"))
  }

  test("reversing one action gives the same action") {
    SecretHandshake.commands(24) should be(List("jump"))
  }

  test("reversing no actions still gives no actions") {
    SecretHandshake.commands(16) should be(List())
  }

}
