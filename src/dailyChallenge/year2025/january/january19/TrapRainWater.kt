package dailyChallenge.year2025.january.january19

import java.util.PriorityQueue

fun main() {
    println(
        trapRainWater(
            heightMap = arrayOf(
                intArrayOf(1, 4, 3, 1, 3, 2),
                intArrayOf(3, 2, 1, 3, 2, 4),
                intArrayOf(2, 3, 3, 2, 3, 1)
            )
        )
    )
}

fun trapRainWater(heightMap: Array<IntArray>): Int {
    val rows = heightMap.size
    val columns = heightMap[0].size
    val dRows = intArrayOf(0, 0, -1, 1)
    val dColumns = intArrayOf(-1, 1, 0, 0)


    val visited = Array(rows) { BooleanArray(columns) { false } }
    val queue = PriorityQueue<Triple<Int, Int, Int>> { (value, _, _), (anotherValue, _, _) ->
        value - anotherValue
    }
    // Traversing the rows
    for (i in 0 until rows) {
        queue.offer(Triple(heightMap[i][0], i, 0))
        queue.offer(Triple(heightMap[i][columns - 1], i, columns - 1))
        visited[i][0] = true
        visited[i][columns - 1] = true
    }
    // Traversing the columns
    for (i in 0 until columns) {
        queue.offer(Triple(heightMap[0][i], 0, i))
        queue.offer(Triple(heightMap[rows - 1][i], rows - 1, i))
        visited[0][i] = true
        visited[rows - 1][i] = true
    }

    var totalWaterVolume = 0
    while (queue.isNotEmpty()) {
        val (currentHeight, row, column) = queue.poll()
        for (direction in 0 until 4) {
            val neighBorColumn = column + dColumns[direction]
            val neighBorRow = row + dRows[direction]

            if ((neighBorColumn in 0 until columns
                        && neighBorRow in 0 until rows)
                && !visited[neighBorRow][neighBorColumn]
            ) {
                val neighBorHeight = heightMap[neighBorRow][neighBorColumn]
                if (neighBorHeight < currentHeight) {
                    totalWaterVolume += (currentHeight - neighBorHeight)
                }
                queue.offer(Triple(maxOf(currentHeight, neighBorHeight), neighBorRow, neighBorColumn))
                visited[neighBorRow][neighBorColumn] = true
            }
        }
    }
    return totalWaterVolume
}

