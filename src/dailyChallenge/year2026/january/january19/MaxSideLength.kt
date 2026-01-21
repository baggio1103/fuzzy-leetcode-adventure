package dailyChallenge.year2026.january.january19

fun main() {
    println(
        maxSideLength(
            matrix = arrayOf(
                intArrayOf(1, 1, 3, 2, 4, 3, 2),
                intArrayOf(1, 1, 3, 2, 4, 3, 2),
                intArrayOf(1, 1, 3, 2, 4, 3, 2),
            ),
            threshold = 4
        )
    )
}

fun maxSideLength(matrix: Array<IntArray>, threshold: Int): Int {
    val m = matrix.size
    val n = matrix[0].size

    val prefix = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) {
        for (j in 1..n) {
            prefix[i][j] =
                matrix[i - 1][j - 1] +
                        prefix[i - 1][j] +
                        prefix[i][j - 1] -
                        prefix[i - 1][j - 1]
        }
    }

    fun canBuild(k: Int): Boolean {
        for (i in k..m) {
            for (j in k..n) {
                val sum =
                    prefix[i][j] -
                            prefix[i - k][j] -
                            prefix[i][j - k] +
                            prefix[i - k][j - k]
                if (sum <= threshold) return true
            }
        }
        return false
    }

    var left = 0
    var right = minOf(m, n)
    var ans = 0

    while (left <= right) {
        val mid = (left + right) / 2
        if (canBuild(mid)) {
            ans = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return ans
}
