package exercism

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class MyRobotNameTest extends AnyFunSpec with Matchers {

  val nameRegex: String = """[A-Z]{2}\d{3}"""

  it("has a name") {
    new MyRobot().name should fullyMatch regex nameRegex
  }

  it("does not change its name") {
    val robot = new MyRobot
    val name = robot.name
    robot.name should be(name)
  }

  it("does not have the same name as other robots") {
    new MyRobot().name should not be new MyRobot().name
  }

  it("can have its name reset") {
    val robot = new MyRobot
    val name = robot.name
    robot.reset()
    val name2 = robot.name
    name should not equal name2
    name2 should fullyMatch regex nameRegex
  }

}
