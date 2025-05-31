package exercism

class ForthEvaluator

class ForthError(x: Int)

class ForthEvaluatorState()

case class StrEvaluatorState(txt: String) extends ForthEvaluatorState {

  override def toString(): String = txt

}
