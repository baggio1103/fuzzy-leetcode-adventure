package dailyChallenge.december.december26


fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
    val dp = Array(n + 1) { IntArray(target + 1) }
    dp[0][0] = 1
    val mod = 1_000_000_007

    for (i in 1..n) {
        for (j in 1..target) {
            for (m in 1..k) {
                if (j - m < 0) {
                    break
                }
                dp[i][j] = (dp[i][j] + dp[i - 1][j - m]) % mod
            }
        }
    }
    return dp[n][target]
}

fun main() {
    println(
        numRollsToTarget(3, 5, 7)
    )
}