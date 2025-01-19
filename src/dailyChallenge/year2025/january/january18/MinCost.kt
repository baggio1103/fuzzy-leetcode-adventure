package dailyChallenge.year2025.january.january18

import java.util.*
import kotlin.math.min

fun main() {
//    [1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]
    println(
        minCost(
            grid = arrayOf(
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 2, 2, 2),
                intArrayOf(1, 1, 1, 1),
                intArrayOf(2, 2, 2, 2),
            )
        )
    )
}

fun minCost(grid: Array<IntArray>): Int {
    val numRows = grid.size
    val numCols = grid[0].size
    val minChanges = Array(numRows) { IntArray(numCols) }

    for (row in minChanges) {
        Arrays.fill(row, Int.MAX_VALUE)
    }
    minChanges[0][0] = 0

    while (true) {

        val prevState = Array(numRows) { IntArray(numCols) }
        for (row in 0 until numRows) {
            prevState[row] = minChanges[row].copyOf(numCols)
        }

        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                // Check cell above
                if (row > 0) {
                    minChanges[row][col] = min(
                        minChanges[row][col].toDouble(),
                        (minChanges[row - 1][col] +
                                (if (grid[row - 1][col] == 3) 0 else 1)).toDouble()
                    ).toInt()
                }
                // Check cell to the left
                if (col > 0) {
                    minChanges[row][col] = min(
                        minChanges[row][col].toDouble(),
                        (minChanges[row][col - 1] +
                                (if (grid[row][col - 1] == 1) 0 else 1)).toDouble()
                    ).toInt()
                }
            }
        }

        for (row in numRows - 1 downTo 0) {
            for (col in numCols - 1 downTo 0) {
                // Check cell below
                if (row < numRows - 1) {
                    minChanges[row][col] = min(
                        minChanges[row][col].toDouble(),
                        (minChanges[row + 1][col] +
                                (if (grid[row + 1][col] == 4) 0 else 1)).toDouble()
                    ).toInt()
                }
                // Check cell to the right
                if (col < numCols - 1) {
                    minChanges[row][col] = min(
                        minChanges[row][col].toDouble(),
                        (minChanges[row][col + 1] +
                                (if (grid[row][col + 1] == 2) 0 else 1)).toDouble()
                    ).toInt()
                }
            }
        }

        if (prevState.contentDeepEquals(minChanges)) {
            break
        }
    }

    return minChanges[numRows - 1][numCols - 1]
}