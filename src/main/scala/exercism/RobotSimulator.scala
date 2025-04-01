package exercism

enum Bearing:
  case North, South, East, West

case class Robot(a: Bearing, b: (Int, Int)):

  def bearing: Bearing = a
  def coordinates: (Int, Int) = b

  def turnLeft: Robot =
    a match {
      case Bearing.North => Robot(Bearing.West, b)
      case Bearing.West  => Robot(Bearing.South, b)
      case Bearing.South => Robot(Bearing.East, b)
      case Bearing.East  => Robot(Bearing.North, b)
    }

  def turnRight: Robot =
    a match {
      case Bearing.North => Robot(Bearing.East, b)
      case Bearing.West  => Robot(Bearing.North, b)
      case Bearing.South => Robot(Bearing.West, b)
      case Bearing.East  => Robot(Bearing.South, b)
    }

  def advance: Robot =
    a match {
      case Bearing.North => Robot(a, (b._1, b._2 + 1))
      case Bearing.West  => Robot(a, (b._1 - 1, b._2))
      case Bearing.South => Robot(a, (b._1, b._2 - 1))
      case Bearing.East  => Robot(a, (b._1 + 1, b._2))
    }

  def simulate(s: String): Robot =
    var z = Robot(a, b)
    for c <- s do
      c match {
        case 'L' => z = z.turnLeft
        case 'R' => z = z.turnRight
        case _   => z = z.advance
      }
    z
