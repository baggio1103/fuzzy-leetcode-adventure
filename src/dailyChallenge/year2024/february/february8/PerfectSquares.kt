package dailyChallenge.year2024.february.february8

import kotlin.math.sqrt

// n = 12, sqrt = 3,  // 3 - 2 - 1

fun numSquares(n: Int): Int {
    var root = sqrt(n.toDouble()).toInt()
    var min = Int.MAX_VALUE
    while (root > 0) {
        val adders = mutableListOf<Int>()
        var sum = 0
        var count = 0
        for (i in root downTo 1) {
            while (sum + i * i <= n) {
                count++
                sum += i * i
                adders.add(i * i)
                if (sum == n) {
                    min = minOf(min, count)
                }
            }
            if (sum == n) {
                break
            }
        }
        root--
    }
    return min
}

fun main() {

    println(
        numSquares(13)
    )

    println(
        numSquares(12
        )
    )
}