package dailyChallenge.year2024.january.january19.matrix

fun minFallingPathSum(matrix: Array<IntArray>): Int {
    for (i in matrix.lastIndex - 1 downTo 0) {
        val row = matrix[i]
        val nextRow = matrix[i + 1]
        for (j in row.indices) {
            val min = minOf(
                nextRow[(j - 1).coerceAtLeast(0)],
                nextRow[j],
                nextRow[(j + 1).coerceAtMost(nextRow.lastIndex)],
            )
            row[j] = row[j] + min
        }
    }
    return matrix[0].min()
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