package dailyChallenge.june.june13

class Solution {

    fun equalPairs(grid: Array<IntArray>): Int {
        val size = grid.size
        val list = Array(size) {
            IntArray(size) {
                it
            }
        }
        for (i in 0 until size) {
            for (j in 0 until size) {
                list[i][j] = grid[j][i]
            }
        }
        return grid.sumOf {
            contains(list, it)
        }
    }

    private fun contains(grid: Array<IntArray>, array: IntArray): Int {
        return grid.count {
            it.contentEquals(array)
        }
    }

}

fun main() {
    val solution = Solution()
    val grid = arrayOf(
        intArrayOf(3, 1, 2, 2),
        intArrayOf(1, 4, 4, 5),
        intArrayOf(2, 4, 2, 2),
        intArrayOf(2, 4, 2, 2),
    )
    println(
        solution.equalPairs(
            grid
        )
    )

    println(
        solution.equalPairs(
            arrayOf(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 7, 6),
                intArrayOf(2, 7, 7),
            )
        )
    )

}