package dailyChallenge.year2024.may.may12

fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
    val matrix = Array(grid.size - 2) { IntArray(grid.size - 2) }
    println("Hello world")
    for (i in 0 until grid.size - 2) {
        for (j in 0 until grid[i].size - 2) {
            matrix[i][j] = maxOf(
                grid[i][j],
                grid[i][j + 1],
                grid[i][j + 2],
                grid[i + 1][j],
                grid[i + 1][j + 1],
                grid[i + 1][j + 2],
                grid[i + 2][j],
                grid[i + 2][j + 1],
                grid[i + 2][j + 2],
            )
        }
    }
    return matrix
}

fun main() {
    val matrix = largestLocal(
        grid = arrayOf(
            intArrayOf(9, 9, 8, 1),
            intArrayOf(5, 2, 6, 2),
            intArrayOf(8, 2, 6, 4),
            intArrayOf(6, 2, 2, 2),
        )
    )
    matrix.forEach {
        println(it.asList())
    }
}