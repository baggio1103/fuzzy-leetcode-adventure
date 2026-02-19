package bytebytego.graphs

fun main() {
    println(
        longestIncreasingPath(
            arrayOf(
                intArrayOf(1, 5, 8),
                intArrayOf(3, 4, 4),
                intArrayOf(7, 9, 2),
            )
        )
    )
    println(
        longestIncreasingPath(
            arrayOf(
                intArrayOf(3, 4, 5),
                intArrayOf(3, 2, 6),
                intArrayOf(2, 2, 1),
            )
        )
    )
    println(
        longestIncreasingPath(
            arrayOf(
                intArrayOf(9, 9, 4),
                intArrayOf(6, 6, 8),
                intArrayOf(2, 1, 1),
            )
        )
    )
    println(
        longestIncreasingPath(
            arrayOf(
                intArrayOf(7, 8, 9),
                intArrayOf(9, 7, 6),
                intArrayOf(7, 2, 3),
            )
        )
    )
}

fun longestIncreasingPath(graph: Array<IntArray>): Int {
    val rows = graph.size
    val columns = graph[0].size
    val dp = Array(rows) { IntArray(columns) }

    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1),
    )

    fun maxPath(r: Int, c: Int): Int {
        if (dp[r][c] != 0) return dp[r][c]
        var path = 1
        for (direction in directions) {
            val nr = r + direction[0]
            val nc = c + direction[1]
            if (
                nr in 0 until rows
                && nc in 0 until columns
                && graph[nr][nc] > graph[r][c]
            ) {
                path = maxOf(path, 1 + maxPath(nr, nc))
            }
        }
        dp[r][c] = path
        return path
    }

    var result = 0
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            result = maxOf(result, maxPath(i, j))
        }
    }

    return result
}
