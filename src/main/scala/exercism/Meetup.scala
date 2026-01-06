import java.time.{YearMonth, DayOfWeek, LocalDate}

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {
  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = {

    val monthSize = YearMonth.of(year, month).lengthOfMonth

    val days = if (schedule == Schedule.Teenth) {
      (13 to 19).filter(f => {
        val localDate = LocalDate.of(year, month, f)
        localDate.getDayOfWeek.getValue == dayOfWeek
      })

    } else {
      (1 to monthSize).filter(d => {
        val localDate = LocalDate.of(year, month, d)
        localDate.getDayOfWeek.getValue == dayOfWeek
      })
    }

    return schedule match {
      case Schedule.First  => LocalDate.of(year, month, days.head)
      case Schedule.Second => LocalDate.of(year, month, days.tail.head)
      case Schedule.Third  => LocalDate.of(year, month, days(2))
      case Schedule.Fourth => LocalDate.of(year, month, days(3))
      case Schedule.Last   => LocalDate.of(year, month, days.last)
      case Schedule.Teenth => LocalDate.of(year, month, days.head)
    }
  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue
}
