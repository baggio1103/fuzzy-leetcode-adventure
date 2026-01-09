package dailyChallenge.year2026.january.january8


fun main() {
    println(maxDotProduct(intArrayOf(5, 1, 3), intArrayOf(2, 4, 6)))
    println(maxDotProduct(intArrayOf(3, -2), intArrayOf(2, -6, 7)))
}

fun maxDotProduct(numsOne: IntArray, numsTwo: IntArray): Int {
    val (rows, cols) = numsOne.size to numsTwo.size
    val dp = Array(rows) { IntArray(cols) { Int.MIN_VALUE } }
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            val product = numsOne[i] * numsTwo[j]
            val inc = product + if (i > 0 && j > 0) maxOf(0, dp[i - 1][j - 1]) else 0
            val skipOne = if (i > 0) dp[i - 1][j] else Int.MIN_VALUE
            val skipTwo = if (j > 0) dp[i][j - 1] else Int.MIN_VALUE
            dp[i][j] = maxOf(inc, skipOne, skipTwo)
        }
    }
    return dp[rows - 1][cols - 1]
}
