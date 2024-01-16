package dailyChallenge.year2024.january.january7

fun numberOfArithmeticSlices(array: IntArray): Int {
    val size = array.size
    val dp = array.map { mutableMapOf<Long, Int>() }
    var totalArithmeticSubsequences = 0
    for (i in 1 until array.size) {
        for (j in 0 until i) {
            val diff = array[i].toLong() - array[j].toLong()
            if (diff !in Int.MIN_VALUE .. Int.MAX_VALUE) {
                continue
            }
            val count = dp[j][diff] ?: 0
            totalArithmeticSubsequences += count + 1
            dp[i][diff] = dp[i].getOrDefault(diff, 0) + count + 1
        }
    }
    return (totalArithmeticSubsequences - (size * (size - 1) / 2)).coerceAtLeast(0)
}

fun main() {
    println(
        numberOfArithmeticSlices(
            intArrayOf(2, 4, 6, 8, 10)
        )
    )
    println(
        numberOfArithmeticSlices(
            intArrayOf(1, 2, 0, 3, 4, 6)
        )
    )
    println(
        numberOfArithmeticSlices(
            intArrayOf(7, 7, 7, 7, 7)
        )
    )
    println(
        numberOfArithmeticSlices(
            intArrayOf(0, 2000000000, -294967296)
        )
    )
}