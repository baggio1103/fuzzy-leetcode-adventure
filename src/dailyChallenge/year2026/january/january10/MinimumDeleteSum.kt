package dailyChallenge.year2026.january.january10

fun main() {
    println(minimumDeleteSum("sea", "eat"))
}

fun minimumDeleteSum(stringOne: String, stringTwo: String): Int {
    val n = stringOne.length
    val m = stringTwo.length
    val dp = Array(n + 1) { IntArray(m + 1) }
    for (i in n - 1 downTo 0) {
        for (j in m - 1 downTo 0) {
            if (stringOne[i] == stringTwo[j]) {
                dp[i][j] = stringOne[i].code + dp[i + 1][j + 1]
            } else
                dp[i][j] = maxOf(dp[i + 1][j], dp[i][j + 1])
        }
    }
    val totalSum = stringOne.sumOf { it.code } + stringTwo.sumOf { it.code }
    return totalSum - 2 * dp[0][0]
}
