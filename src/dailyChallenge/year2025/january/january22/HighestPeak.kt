package dailyChallenge.year2025.january.january22

import java.util.*


fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
    val dx = intArrayOf(0, 0, 1, -1)
    val dy = intArrayOf(1, -1, 0, 0)
    val rows = isWater.size
    val columns = isWater[0].size

    val cellHeights = Array(rows) { IntArray(columns) }
    for (row in cellHeights) {
        Arrays.fill(row, -1)
    }

    val cellQueue: Queue<IntArray> = LinkedList()

    for (x in 0 until rows) {
        for (y in 0 until columns) {
            if (isWater[x][y] == 1) {
                cellQueue.add(intArrayOf(x, y))
                cellHeights[x][y] = 0
            }
        }
    }

    var heightOfNextLayer = 1

    while (!cellQueue.isEmpty()) {
        val layerSize = cellQueue.size

        for (i in 0 until layerSize) {
            val currentCell = cellQueue.poll()

            for (d in 0..3) {
                val neighborX = currentCell[0] + dx[d]
                val neighborY = currentCell[1] + dy[d]

                if ((isValidCell(neighborX, neighborY, rows, columns)) &&
                    cellHeights[neighborX][neighborY] == -1
                ) {
                    cellHeights[neighborX][neighborY] = heightOfNextLayer
                    cellQueue.add(intArrayOf(neighborX, neighborY))
                }
            }
        }
        heightOfNextLayer++
    }

    return cellHeights
}

// Function to check if a cell is within the grid boundaries
fun isValidCell(x: Int, y: Int, rows: Int, columns: Int): Boolean {
    return x in 0 until rows && y in 0 until columns
}
