package exercism

class Clock(var hour: Int, var minute: Int) {

  var totalMinutes =
    (hour * 60 + minute) % (24 * 60)

  if (totalMinutes < 0) {
    totalMinutes += (60 * 24)
  }

  hour = totalMinutes / 60
  minute = totalMinutes % 60

  def this(minutes: Int) = this(0, minutes)

  def +(other: Clock): Clock = Clock(hour + other.hour, minute + other.minute)

  def -(other: Clock): Clock = Clock(hour - other.hour, minute - other.minute)

  override def equals(that: Any): Boolean = {
    val other = that.asInstanceOf[Clock]
    hour == other.hour && minute == other.minute
  }
}
