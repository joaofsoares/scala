package exercism

object SpaceAge {

  private val earthSeconds = 31557600.0

  def onEarth(age: Double): Double = age / earthSeconds / 1.0

  def onVenus(age: Double): Double = age / earthSeconds / 0.61519726

  def onMercury(age: Double): Double = age / earthSeconds / 0.2408467

  def onMars(age: Double): Double = age / earthSeconds / 1.8808158

  def onJupiter(age: Double): Double = age / earthSeconds / 11.862615

  def onSaturn(age: Double): Double = age / earthSeconds / 29.447498

  def onUranus(age: Double): Double = age / earthSeconds / 84.016846

  def onNeptune(age: Double): Double = age / earthSeconds / 164.79132

}
