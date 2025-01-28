package dailyChallenge.year2025.january.january28

fun main() {
//    println(
//        findMaxFish(
//            grid = arrayOf(
//                intArrayOf(0, 2, 1, 0),
//                intArrayOf(4, 0, 0, 3),
//                intArrayOf(1, 0, 0, 4),
//                intArrayOf(0, 3, 2, 0),
//            )
//        )
//    )
    println(
        findMaxFish(
            grid = arrayOf(
                intArrayOf(8, 6),
                intArrayOf(2, 6),
            )
        )
    )
}

fun findMaxFish(grid: Array<IntArray>): Int {
    var maxCount = 0
    val rows = grid.size
    val columns = grid[0].size
    val visited = Array(rows) { BooleanArray(columns) { false } }

    fun adjacentEdges(row: Int, column: Int) =
        listOf(Pair(row - 1, column), Pair(row + 1, column), Pair(row, column + 1), Pair(row, column - 1))

    fun search(i: Int, j: Int): Int {
        val queue = ArrayDeque<Pair<Int, Int>>().apply { add(Pair(i, j)) }
        visited[i][j] = true
        var count = 0
        while (queue.isNotEmpty()) {
            val (row, column) = queue.removeFirst()
            visited[row][column] = true
            val value = grid[row][column]
            count += value
            adjacentEdges(row, column).filter { (r, c) ->
                (r in 0 until rows && c in 0 until columns) && !visited[r][c] && grid[r][c] > 0
            }.forEach {
                visited[it.first][it.second] = true
                queue.add(it)
            }
        }
        return count
    }

    for ((i, row) in grid.withIndex()) {
        for ((j, cell) in row.withIndex()) {
            if (cell > 0 && !visited[i][j]) {
                maxCount = maxOf(maxCount, search(i, j))
            }
        }
    }
    return maxCount
}