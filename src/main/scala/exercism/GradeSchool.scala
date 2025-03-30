package exercism

class GradeSchool

class School:
  private type DB = Map[Int, Seq[String]]
  private var currentDB: DB = Map()

  def add(name: String, g: Int): Unit =
    currentDB.get(g) match {
      case Some(seq) =>
        currentDB = currentDB + (g -> (seq.toList :+ name))
      case None =>
        currentDB = currentDB + (g -> List(name))
    }

  def db: DB = currentDB

  def grade(g: Int): Seq[String] = currentDB.get(g) match {
    case Some(value) => value
    case None        => Seq()
  }

  def sorted: DB =
    currentDB.toSeq.sorted.map((k, v) => (k, v.sorted)).toMap
