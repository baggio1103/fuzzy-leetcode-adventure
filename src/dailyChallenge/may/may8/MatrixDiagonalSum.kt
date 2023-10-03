package dailyChallenge.may.may8

class MatrixDiagonalSum {

    fun diagonalSum(matrix: Array<IntArray>): Int {
        var sum = 0
        matrix.forEachIndexed { index, array ->
            sum += array[index]
            sum += array[array.lastIndex - index]
        }
        if (matrix.size % 2 != 0) {
            val middle = matrix.size / 2
            sum -= matrix[middle][middle]
        }
        return sum
    }

}

fun main() {
    val matrixDiagonalSum = MatrixDiagonalSum()
    val oneMatrix = arrayOf(
        intArrayOf(1)
    )
    println(
        matrixDiagonalSum.diagonalSum(oneMatrix)
    )
    val doubleMatrix = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4),
    )
    println(
        matrixDiagonalSum.diagonalSum(doubleMatrix)
    )
    val tripleMatrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )
    val quadrupleMatrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8),
        intArrayOf(9, 10, 11, 12),
        intArrayOf(13, 14, 15, 16),
    )

    val quinTuple = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(11, 12, 13, 14, 15),
        intArrayOf(16, 17, 18, 19, 20),
        intArrayOf(21, 22, 23, 24, 25),
    )
    println(matrixDiagonalSum.diagonalSum(tripleMatrix))
    println(
        matrixDiagonalSum.diagonalSum(quadrupleMatrix)
    )
    println(
        matrixDiagonalSum.diagonalSum(quinTuple)
    )
}