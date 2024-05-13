package dailyChallenge.year2024.may.may13

import kotlin.math.pow

// First maximize rows
// Second maximize columns

// 1, 1, 0, 0
// 1, 0, 1, 0
// 1, 1, 0, 0
// ====>
// 1, 1, 1, 1
// 1, 0, 0, 1
// 1, 1, 1, 1

fun matrixScore(grid: Array<IntArray>): Int {
    for (i in grid.indices) {
        val row = grid[i]
        if (row[0] != 1) {
            for ((j, value) in row.withIndex()) {
                if (value == 0) {
                    row[j] = 1
                } else row[j] = 0
            }
        }
    }
    for (j in grid[0].indices) {
        // count ones in the column
        var ones = 0
        for (i in grid.indices) {
            if (grid[i][j] == 1) ones++
        }
        // more zeros in the column, flip the bits
        if (ones < (grid.size + 1) / 2) {
            for (i in grid.indices) {
                if (grid[i][j] == 0) grid[i][j] = 1 else grid[i][j] = 0
            }
        }
    }
    var overallSum = 0.0
    grid.forEach { row ->
        var sum = 0.0
        val base = 2.0
        val size = row.lastIndex
        for (i in size downTo 0) {
            val bit = row[i]
            if (bit == 0) continue
            sum += base.pow(size - i)
        }
        overallSum += sum
    }
    return overallSum.toInt()
}

fun main() {
    println(
        matrixScore(
            grid = arrayOf(
                intArrayOf(0, 0, 1, 1),
                intArrayOf(1, 0, 1, 0),
                intArrayOf(1, 1, 0, 0),
            )
        )
    )
}