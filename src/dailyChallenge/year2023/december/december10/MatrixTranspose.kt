package dailyChallenge.december.december10

fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val transposedMatrix = Array(matrix[0].size) {
        IntArray(matrix.size)
    }
    matrix.forEachIndexed { index, row ->
        row.forEachIndexed { i, value ->
            transposedMatrix[i][index] = value
        }
    }
    return transposedMatrix
}

fun main() {
    transpose(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
    )

    transpose(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
        )
    )
}