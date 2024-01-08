package dailyChallenge.year2024.january.january5.opt

import kotlin.math.max

fun lengthOfLIS(array: IntArray): Int {
    var lis = 0
    val dp = IntArray(array.size) { _ -> 1 }

    for (i in array.indices) {
        for (j in 0 until i) {
            if (array[j] < array[i]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
        lis = max(lis, dp[i])
    }
    return lis.also {
        println("Result: $it")
    }
}

fun main() {
    lengthOfLIS(
        intArrayOf(4, 10, 4, 3, 8, 9)
    )
    lengthOfLIS(
        intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)
    )
    lengthOfLIS(
        intArrayOf(0, 1, 0, 3, 2, 3)
    )
    lengthOfLIS(
        intArrayOf(7, 7, 7, 7, 7, 7, 7)
    )
    lengthOfLIS(
        intArrayOf(0)
    )
}