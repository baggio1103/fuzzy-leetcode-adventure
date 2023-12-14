package dailyChallenge.december.december14

fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val rows = grid.size
    val columns = grid[0].size
    val rowOnes = IntArray(rows)
    val columnOnes = IntArray(columns)
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (grid[i][j] == 1) {
                rowOnes[i]++
                columnOnes[j]++
            }
        }
    }
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            grid[i][j] = rowOnes[i] + columnOnes[j] - (rows - rowOnes[i] + columns - columnOnes[j])
        }
    }
    return grid
}

fun main() {
    val array = arrayOf(
        intArrayOf(0, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(0, 0, 1)
    )
    onesMinusZeros(
        array
    ).forEach {
        println(it.asList())
    }
}