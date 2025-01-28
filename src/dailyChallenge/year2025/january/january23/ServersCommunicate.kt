package dailyChallenge.year2025.january.january23


fun main() {
    println(
        countServers(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )
        )
    )
    println(
        countServers(
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 1)
            )
        )
    )
    println(
        countServers(
            grid = arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(0, 0, 1),
                intArrayOf(0, 1, 0),
            )
        )
    )
    println(
        countServers(
            grid = arrayOf(
                intArrayOf(1, 0, 1),
                intArrayOf(0, 1, 1),
                intArrayOf(1, 1, 0),
            )
        )
    )
    println(
        countServers(
            grid = arrayOf(
                intArrayOf(1,0,0,1,0),
                intArrayOf(0,0,0,0,0),
                intArrayOf(0,0,0,1,0),
            )
        )
    )
}
fun countServers(grid: Array<IntArray>): Int {
    var overallCount = 0
    val visited = Array(grid.size) { BooleanArray(grid[0].size) }
    val rowSize = grid.size
    val colSize = grid[0].size

    fun search(x: Int, y: Int): Int {
        var count = 1
        val queue = ArrayDeque<Pair<Int, Int>>()
            .apply { add(Pair(x, y)) }
        visited[x][y] = true
        while (queue.isNotEmpty()) {
            val (row, column) = queue.removeFirst()
            // rows
            for (i in 0 until colSize) {
                if (grid[row][i] == 1 && !visited[row][i]) {
                    queue.add(Pair(row, i))
                    visited[row][i] = true
                    count++
                }
            }

            // columns
            for (i in 0 until rowSize) {
                if (grid[i][column] == 1 && !visited[i][column]) {
                    queue.add(Pair(i, column))
                    visited[i][column] = true
                    count++
                }
            }
        }
        return if (count == 1) 0 else count
    }

    for ((i, row) in grid.withIndex()) {
        for ((j, value) in row.withIndex()) {
            if (value == 1 && !visited[i][j]) {
                overallCount += search(i, j)
            }
        }
    }
    return overallCount
}