import java.lang.IllegalArgumentException
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

fun nextDateByDay(givenDay: DayOfWeek): LocalDate {
    var day = when (LocalDate.now().dayOfWeek) {
        DayOfWeek.MONDAY -> LocalDate.now().plusDays(7)
        DayOfWeek.TUESDAY -> LocalDate.now().plusDays(6)
        DayOfWeek.WEDNESDAY -> LocalDate.now().plusDays(5)
        DayOfWeek.THURSDAY -> LocalDate.now().plusDays(4)
        DayOfWeek.FRIDAY -> LocalDate.now().plusDays(3)
        DayOfWeek.SATURDAY -> LocalDate.now().plusDays(2)
        DayOfWeek.SUNDAY -> LocalDate.now().plusDays(1)
        else -> throw IllegalArgumentException("Day of week cannot be null")
    }
    while (day.dayOfWeek != givenDay) {
        day = day.plusDays(1)
    }
    return day
}


fun isValidDay(date: LocalDateTime = LocalDateTime.now()) {
    when (date.dayOfWeek) {
        in DayOfWeek.THURSDAY..DayOfWeek.SATURDAY -> {
            println("VALID: $date ${date.dayOfWeek}")
        }
        !in DayOfWeek.THURSDAY..DayOfWeek.SATURDAY -> {
            println("INVALID: $date ${date.dayOfWeek}")
        }

        else -> {}
    }
}


fun main() {
    println(
        nextDateByDay(DayOfWeek.THURSDAY)
    )

    println(
        LocalDateTime.of(nextDateByDay(DayOfWeek.MONDAY), LocalTime.MIN)
    )

    println(
        LocalDateTime.of(nextDateByDay(DayOfWeek.SUNDAY), LocalTime.MAX)
    )

    isValidDay()
    isValidDay(LocalDateTime.now().plusDays(3))
    isValidDay(LocalDateTime.now().plusDays(4))
    isValidDay(LocalDateTime.now().plusDays(5))
    val a = (DayOfWeek.THURSDAY..DayOfWeek.SUNDAY)
    println(
        a.contains(LocalDateTime.now().dayOfWeek)
    )
    println(
        LocalDateTime.now().dayOfWeek in (DayOfWeek.THURSDAY..DayOfWeek.SUNDAY)
    )
}

