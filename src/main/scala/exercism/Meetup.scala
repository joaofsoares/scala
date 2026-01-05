import java.time.{YearMonth, DayOfWeek, LocalDate}
import java.time.temporal.ChronoUnit

import Schedule.Schedule

case class Meetup(month: Int, year: Int) {
  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = {
    val monthSize = YearMonth.of(year, month).lengthOfMonth

    // val start = LocalDate.of(year, month, 1)
    // val end = LocalDate.of(year, month, monthSize)

    // val weeks = ChronoUnit.WEEKS.between(start, end)

    // println(s"weeks = $weeks")

    // val mondays = (1 to monthSize)
    // .filter(i => {
    // val localDate = LocalDate.of(year, month, i)
    // localDate.getDayOfWeek.getValue == dayOfWeek
    // })

    var result: LocalDate = null

    schedule match {
      case Schedule.First =>
        for i <- 1 to 7 do {
          val localDate = LocalDate.of(year, month, i)
          if (localDate.getDayOfWeek.getValue == dayOfWeek) {
            result = localDate
          }
        }
      case Schedule.Second =>
        for i <- 8 to 15 do {
          val localDate = LocalDate.of(year, month, i)
          if (localDate.getDayOfWeek.getValue == dayOfWeek) {
            result = localDate
          }
        }
      case Schedule.Third =>
        for i <- 15 to 22 do {
          val localDate = LocalDate.of(year, month, i)
          if (localDate.getDayOfWeek.getValue == dayOfWeek) {
            result = localDate
          }
        }
      case Schedule.Fourth =>
        for i <- 22 to 29 do {
          val localDate = LocalDate.of(year, month, i)
          if (localDate.getDayOfWeek.getValue == dayOfWeek) {
            result = localDate
          }
        }
      case Schedule.Last =>
        for i <- 29 to monthSize do {
          val localDate = LocalDate.of(year, month, i)
          if (localDate.getDayOfWeek.getValue == dayOfWeek) {
            result = localDate
          }
        }
      case Schedule.Teenth =>
        for i <- 13 to 19 do {
          val localDate = LocalDate.of(year, month, i)
          if (localDate.getDayOfWeek.getValue == dayOfWeek) {
            result = localDate
          }
        }
    }

    result
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
