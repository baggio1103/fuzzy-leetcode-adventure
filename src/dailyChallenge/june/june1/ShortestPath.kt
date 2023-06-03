package dailyChallenge.june.june1

class ShortestPath {

    fun shortestPathBinaryMatrix(
        grid: Array<IntArray>,
        currentRow: Int = 0,
        currentColumn: Int = 0,
        rowCount: Int = grid.lastIndex,
        columnCount: Int = grid[0].lastIndex,
        currentNode: Int = 1
    ): Int {
        if (currentRow == rowCount && currentColumn == columnCount) {
            return if (grid[rowCount][columnCount] == 0) 0 else 1
        }
        if (currentColumn == columnCount) {
            shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1)
            shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1)
            shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn)

        } else if (currentRow == rowCount) {
            shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1)
            shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1)
            shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn)

        } else {
            shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1)
            shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1)
            shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn)
        }
        return 0
    }

}

fun main() {
    val shortestPath = ShortestPath()
    shortestPath.shortestPathBinaryMatrix(
        arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 0, 0),
        )
    )
}
