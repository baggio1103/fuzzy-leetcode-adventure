package dailyChallenge.year2024.february.february3.iterative

import kotlin.math.max

fun maxSumAfterPartitioning(array: IntArray, k: Int): Int {
    val dp = IntArray(array.size + 1) { _ -> 0 }
    for (i in array.lastIndex downTo 0) {
        var maxValue = array[i]
        var dpMax = dp[i]
        for (j in i .. (i + k - 1).coerceAtMost(array.lastIndex)) {
            maxValue = maxOf(maxValue, array[j])
            val subArrayMaxSum = maxValue * (j + 1 - i)
            val cache = dp[j + 1]
            dpMax = max(dpMax, cache + subArrayMaxSum)
        }
        dp[i] = dpMax
    }
    return dp[0]
}

fun main() {
    println(
        maxSumAfterPartitioning(
            intArrayOf(1, 5, 6, 7),
            2
        )
    )
    println(
        maxSumAfterPartitioning(
            intArrayOf(1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3),
            4
        )
    )
}