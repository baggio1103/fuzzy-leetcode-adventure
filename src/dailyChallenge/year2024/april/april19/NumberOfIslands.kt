package dailyChallenge.year2024.april.april19

import java.util.ArrayDeque

fun numIslands(grid: Array<CharArray>): Int {
    // Pair(int, int) -> row, column
    val queue = ArrayDeque<Pair<Int, Int>>()
    val visited = Array(grid.size) {
        IntArray(grid[0].size)
    }
    var count = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (visited[i][j] == 1 || grid[i][j] == '0') continue
            count++
            queue.add(Pair(i, j))
            visited[i][j] = 1
            while (queue.isNotEmpty()) {
                val (row, column) = queue.poll()
                // left, top, right, bottom
                val adjCells =
                    arrayOf(Pair(row, column - 1), Pair(row - 1, column), Pair(row, column + 1), Pair(row + 1, column))
                for ((r, c) in adjCells) {
                    if (r in grid.indices && c in grid[0].indices && visited[r][c] == 0 && grid[r][c] == '1') {
                        queue.add(Pair(r, c))
                        visited[r][c] = 1
                    }
                }
            }
        }
    }
    return count
}

fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '0', '1', '0', '1'),
                charArrayOf('1', '1', '1', '0', '1'),
            )
        )
    )
    println(
        numIslands(
            grid = arrayOf(
                charArrayOf('1'),
                charArrayOf('1')
            )
        )
    )
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0'),
            )
        )
    )
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1'),
            )
        )
    )
}