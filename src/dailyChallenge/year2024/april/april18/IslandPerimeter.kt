package dailyChallenge.year2024.april.april18

fun islandPerimeter(grid: Array<IntArray>): Int {
    var perimeter = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                perimeter += 4

                if (i > 0 && grid[i - 1][j] == 1) {
                    perimeter -= 2
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    perimeter -= 2
                }
            }
        }
    }
    return perimeter
}

fun main() {
    println(
        islandPerimeter(
            grid = arrayOf(
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 0, 0),
            )
        )
    )
}