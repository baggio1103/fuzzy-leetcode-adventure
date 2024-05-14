package dailyChallenge.year2024.may.may14

fun getMaximumGold(grid: Array<IntArray>): Int {
    val rows = grid.size
    val columns = grid[0].size
    var maxValue = 0
    val visited = Array(rows) { IntArray(columns) }

    fun collect(r: Int, c: Int): Int {
        if (minOf(r, c) < 0 || c == columns || r == rows
            || grid[r][c] == 0 || visited[r][c] != 0
        ) {
            return 0
        }
        visited[r][c] = 1
        var gold = grid[r][c]
        listOf(
            Pair(r - 1, c), Pair(r + 1, c), Pair(r, c - 1), Pair(r, c + 1),
        ).forEach { (i, j) ->
            gold = maxOf(gold, grid[r][c] + collect(i, j))
        }
        visited[r][c] = 0
        return gold
    }

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (grid[i][j] != 0) {
                // collect gold
                maxValue = maxOf(maxValue, collect(i, j))
            }
        }
    }
    return maxValue
}

fun main() {
    println(
        getMaximumGold(
            grid = arrayOf(
                intArrayOf(0, 6, 0),
                intArrayOf(5, 8, 7),
                intArrayOf(0, 9, 0),
            )
        )
    )
}