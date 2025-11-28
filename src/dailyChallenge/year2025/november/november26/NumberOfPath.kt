package dailyChallenge.year2025.november.november26

fun main() {
    println(
        numberOfPaths(
            grid = arrayOf(
                intArrayOf(5, 2, 4),
                intArrayOf(3, 0, 5),
                intArrayOf(0, 7, 2),
            ),
            3
        )
    )
}

fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
    val mod = 1_000_000_007
    val row = grid.size
    val column = grid[0].size

    val dp = Array(row) { Array(column) { IntArray(k) { -1 } } }

    fun dfs(i: Int, j: Int, r: Int): Int {
        if (i >= row || j >= column) return 0
        val newR = (r + grid[i][j]) % k
        // Reached bottom-right
        if (i == row - 1 && j == column - 1)
            return if (newR == 0) 1 else 0

        if (dp[i][j][newR] != -1) return dp[i][j][newR]

        val ways = (dfs(i + 1, j, newR) + dfs(i, j + 1, newR)) % mod
        dp[i][j][newR] = ways
        return ways
    }

    return dfs(0, 0, 0)
}