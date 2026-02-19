package bytebytego.graphs

import java.util.Stack

fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0'),
                charArrayOf('1', '1', '0', '0'),
                charArrayOf('0', '0', '1', '1'),
                charArrayOf('0', '0', '0', '1'),
            )
        )
    )
}

fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    val rows = grid.size
    val columns = grid[0].size
    val visited = mutableSetOf<Pair<Int, Int>>()

    fun dfs(i: Int, j: Int) {
        val stack = Stack<Pair<Int, Int>>()
        stack.push(i to j)
        while (stack.isNotEmpty()) {
            val (r, c) = stack.pop()
            visited.add(r to c)
            arrayOf(
                r + 1 to c,
                r - 1 to c,
                r to c + 1,
                r to c - 1
            ).forEach { (row, column) ->
                if (
                    row in 0 until rows
                    && column in 0 until columns
                    && grid[row][column] == '1'
                    && row to column !in visited
                ) stack.push(row to column)
            }
        }
    }

    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (grid[i][j] == '1' && (i to j) !in visited) {
                dfs(i, j)
                count++
            }
        }
    }

    return count
}
