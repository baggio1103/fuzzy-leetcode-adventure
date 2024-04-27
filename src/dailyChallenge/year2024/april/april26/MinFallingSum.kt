package dailyChallenge.year2024.april.april26

fun minFallingPathSum(grid: Array<IntArray>): Int {
    for (i in grid.lastIndex - 1 downTo 0) {
        val row = grid[i]
        val nextRow = grid[i + 1]
        val (minIndex, minOne) = minimum(nextRow, -1)
        val (_, minTwo) = minimum(nextRow, minIndex)
        for (j in row.indices) {
            if (j != minIndex) {
                row[j] += minOne
                continue
            }
            row[j] += minTwo
        }
    }
    return grid[0].min()
}

fun minimum(nextRow: IntArray, index: Int): Pair<Int, Int> {
    var minValue = Int.MAX_VALUE
    var minIndex = 0
    for ((i, value) in nextRow.withIndex()) {
        if (i != index && value < minValue) {
            minValue = value
            minIndex = i
        }
    }
    return Pair(minIndex, minValue)
}

fun main() {
    println(
        minFallingPathSum(
            grid = arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
        )
    )
}