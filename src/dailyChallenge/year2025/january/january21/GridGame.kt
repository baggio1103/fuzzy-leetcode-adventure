package dailyChallenge.year2025.january.january21

fun main() {
    println(
        gridGame(
            arrayOf(
                intArrayOf(2, 5, 4),
                intArrayOf(1, 5, 1),
            )
        )
    )
    println(
        gridGame(
            arrayOf(
                intArrayOf(2, 4, 6),
                intArrayOf(8, 9, 10),
            )
        )
    )

}

fun gridGame(grid: Array<IntArray>): Long {
    val columnSize = grid[0].size
    val prefixSumRowOne = LongArray(columnSize)
    val prefixSumRowTwo = LongArray(columnSize)
    prefixSumRowOne[0] = (grid[0][0]).toLong()
    prefixSumRowTwo[0] = (grid[1][0]).toLong()
    for (i in 1 until columnSize) {
        prefixSumRowOne[i] = prefixSumRowOne[i - 1] + grid[0][i]
        prefixSumRowTwo[i] = prefixSumRowTwo[i - 1] + grid[1][i]
    }
    var result = Long.MAX_VALUE
    for (i in 0 until columnSize) {
        val top = prefixSumRowOne.last() - prefixSumRowOne[i]
        val bottom = if (i == 0) 0 else prefixSumRowTwo[i - 1]
        val secondRobot = maxOf(top, bottom)
        result = minOf(result, secondRobot)
    }
    return result
}