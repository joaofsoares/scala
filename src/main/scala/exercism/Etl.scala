package exercism

object Etl:
  def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] =
    scoreMap.flatMap(a => a._2.flatMap(b => Map(b.toLowerCase -> a._1)))
