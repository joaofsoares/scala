package exercism

import scala.util.Random

object RobotName

class MyRobot():

  private var robotName: String = generateName

  def name: String = robotName
  def reset(): Unit =
    robotName = generateName

  private def generateName: String =
    val rand: Random = Random()

    val a1, a2 = rand.alphanumeric.filter(_.isLetter).head.toUpper
    val n1, n2, n3 = rand.nextInt(10)

    s"$a1$a2$n1$n2$n3"
