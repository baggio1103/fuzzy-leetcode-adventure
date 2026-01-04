package dailyChallenge.year2026.january.january4

import kotlin.math.sqrt

fun main() {
    println(sumFourDivisors(intArrayOf(27)))
    println(sumFourDivisors(intArrayOf(21, 4, 125)))
    println(sumFourDivisors(intArrayOf(21, 4, 125, 27)))
    println(sumFourDivisors(intArrayOf(21, 4, 21)))
}

fun sumFourDivisors(numbers: IntArray): Int {
    var totalSum = 0
    for (number in numbers) {
        val divisors = mutableSetOf<Int>()
        var i = 1
        while (i * i <= number) {
            if (number % i == 0) {
                divisors.add(i)
                divisors.add(number / i)
            }
            i++
        }
        if (divisors.size == 4) totalSum += divisors.sum()
    }
    return totalSum
}
