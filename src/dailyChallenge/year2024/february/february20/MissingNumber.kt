package dailyChallenge.year2024.february.february20

fun missingNumber(numbers: IntArray): Int {
    val n = numbers.size + 1
    val overallSum = (0 + n - 1) / 2.0 * n
    return overallSum.toInt() - numbers.sum()
}

fun main() {
    println(
        missingNumber(intArrayOf(0, 1, 3))
    )
    println(
        missingNumber(
            intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)
        )
    )
}

