package yandexContest

import java.math.BigDecimal
import java.math.RoundingMode
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.math.absoluteValue

//1
//10 10.02 11.05
//10 11.12 23.12

fun main() {
    val count = readln().toInt()
    val pattern = DateTimeFormatter.ofPattern("yyyy.dd.MM")
    val payments = arrayListOf<String>()
    for (i in 0 until count) {
        payments.add(readln())
    }
    val quarterPayments = mutableMapOf<Int, BigDecimal>(
        1 to BigDecimal.ZERO,
        2 to BigDecimal.ZERO,
        3 to BigDecimal.ZERO,
        4 to BigDecimal.ZERO,
    )
    payments.forEach {
        val splitValues = it.split(" ")
        val amount = splitValues[0].toDouble()
        val start = LocalDate.parse("2022.${splitValues[1]}", pattern)
        val end = LocalDate.parse("2022.${splitValues[2]}", pattern)
        val daysDifference = ChronoUnit.DAYS.between(start, end.plusDays(1)).absoluteValue
        val paidValue = BigDecimal.valueOf(amount / daysDifference).setScale(2, RoundingMode.DOWN)
        val startQuarter = quarter(start)
        val endQuarter = quarter(end)
            when (endQuarter.first - startQuarter.first) {
                0 -> {
                    val difference = ChronoUnit.DAYS.between(start, end.plusDays(1)).absoluteValue
                    val sum = quarterPayments[startQuarter.first]!!
                    paidValue * difference.toBigDecimal()
                    quarterPayments[startQuarter.first] = sum.add(paidValue * difference.toBigDecimal())
                }
                1 -> {
                    var difference = ChronoUnit.DAYS.between(start, startQuarter.third.plusDays(1)).absoluteValue
                    var sum = quarterPayments[startQuarter.first]!!
                    var value = paidValue * difference.toBigDecimal()
                    quarterPayments[startQuarter.first] = sum + value

                    difference = ChronoUnit.DAYS.between(end.plusDays(1), endQuarter.second).absoluteValue
                    sum = quarterPayments[endQuarter.first]!!
                    value = paidValue * difference.toBigDecimal()
                    quarterPayments[endQuarter.first] = sum + value
                }
                2 -> {
                    // 1 - 2 - 3; 1 and 3 are borders
                    var difference = ChronoUnit.DAYS.between(start, startQuarter.third.plusDays(1)).absoluteValue
                    var value = paidValue * difference.toBigDecimal()
                    var sum = quarterPayments[startQuarter.first]!!
                    quarterPayments[startQuarter.first] = sum + value

                    difference = ChronoUnit.DAYS.between(startQuarter.third.plusDays(1), endQuarter.second).absoluteValue
                    value = paidValue * difference.toBigDecimal()
                    sum = quarterPayments[startQuarter.first + 1]!!
                    quarterPayments[startQuarter.first + 1] = sum + value

                    difference = ChronoUnit.DAYS.between(endQuarter.second, end.plusDays(1)).absoluteValue
                    value = paidValue * difference.toBigDecimal()
                    sum = quarterPayments[endQuarter.first]!!
                    quarterPayments[endQuarter.first] = value + sum
                }
                3 -> {
                    // 1 - 2 - 3 - 4
                    var difference = ChronoUnit.DAYS.between(start, startQuarter.third.plusDays(1)).absoluteValue
                    var value = paidValue * difference.toBigDecimal()
                    var sum = quarterPayments[startQuarter.first]!!
                    quarterPayments[startQuarter.first] = sum + value


                    var midQuarter = quarter(startQuarter.third.plusDays(1).toLocalDate())
                    difference = ChronoUnit.DAYS.between(midQuarter.second, midQuarter.third.plusDays(1)).absoluteValue
                    value = paidValue * difference.toBigDecimal()
                    sum = quarterPayments[midQuarter.first]!!
                    quarterPayments[midQuarter.first] = sum + value

                    midQuarter = quarter(midQuarter.third.plusDays(1).toLocalDate())
                    difference = ChronoUnit.DAYS.between(midQuarter.second, midQuarter.third.plusDays(1)).absoluteValue
                    value = paidValue * difference.toBigDecimal()
                    sum = quarterPayments[midQuarter.first]!!
                    quarterPayments[midQuarter.first] = sum + value


                    difference = ChronoUnit.DAYS.between(end.plusDays(1), endQuarter.second).absoluteValue
                    value = paidValue * difference.toBigDecimal()
                    sum = quarterPayments[endQuarter.first]!!
                    quarterPayments[endQuarter.first] = value + sum
                }
            }
    }
    quarterPayments.values.forEach { println(it) }
}

fun quarter(date: LocalDate): Triple<Int, LocalDateTime, LocalDateTime> {
    return when (date.month) {
        Month.JANUARY, Month.FEBRUARY, Month.MARCH -> {
            Triple(
                1,
                LocalDateTime.of(LocalDate.of(date.year, Month.JANUARY, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, Month.MARCH, Month.MARCH.maxLength()), LocalTime.MAX)
            )
        }
        Month.APRIL, Month.MAY, Month.JUNE -> {
            Triple(
                2,
                LocalDateTime.of(LocalDate.of(date.year, Month.APRIL, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, Month.JUNE, Month.JUNE.maxLength()), LocalTime.MAX)
            )
        }

        Month.JULY, Month.AUGUST, Month.SEPTEMBER -> {
            Triple(
                3,
                LocalDateTime.of(LocalDate.of(date.year, Month.JULY, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, Month.SEPTEMBER, Month.SEPTEMBER.maxLength()), LocalTime.MAX)
            )

        }
        Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER -> {
            Triple(
                4,
                LocalDateTime.of(LocalDate.of(date.year, Month.OCTOBER, 1), LocalTime.MIN),
                LocalDateTime.of(LocalDate.of(date.year, Month.DECEMBER, Month.DECEMBER.maxLength()), LocalTime.MAX)
            )
        }
        null -> throw IllegalArgumentException("Month cannot be null!")
    }
}
