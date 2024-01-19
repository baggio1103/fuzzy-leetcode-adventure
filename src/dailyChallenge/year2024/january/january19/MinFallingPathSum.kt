package dailyChallenge.year2024.january.january19

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    val cache = mutableMapOf<String, Int>()

    fun down(matrix: Array<IntArray>, row: Int = 0, index: Int = 0, cache: MutableMap<String, Int>): Int {
        val cached = cache["$row-$index"]
        if (cached != null) {
            return cached
        }
        if (row == matrix.lastIndex) {
            return matrix[row][index]
        }
        val value = listOf(index - 1, index, index + 1).filter { it in 0 .. matrix.lastIndex }.minOf {
            down(matrix, row + 1, it, cache)
        } + matrix[row][index]
        cache["$row-$index"] = value
        return value
    }

    return IntRange(0, matrix[0].lastIndex).minOfOrNull { index ->
        down(matrix, 0, index, cache)
    } ?: 0
}

fun main() {
    println(
        minFallingPathSum(
            arrayOf(
                intArrayOf(2, 1, 3),
                intArrayOf(6, 5, 4),
                intArrayOf(7, 8, 9),
            )
        )
    )
    println(
        minFallingPathSum(
            arrayOf(
                intArrayOf(-19, 57),
                intArrayOf(-40, -5),
            )
        )
    )

    println(
        minFallingPathSum(
            arrayOf(
                intArrayOf(100, -42, -46, -41),
                intArrayOf(31, 97, 10, -10),
                intArrayOf(-58, -51, 82, 89),
                intArrayOf(51, 81, 69, -51),
            )
        )
    )

}