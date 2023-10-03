package dailyChallenge.may.may10

class SpiralMatrix {

    fun generateMatrix(n: Int): Array<IntArray> {
        val matrix = List(n) {
            List(n) {
                    _ -> -1
            }.toIntArray()
        }.toTypedArray()
        val size = n * n
        var count = 0
        var matrixValue = 1
        var rowStart = 0
        var columnStart = 0
        var rowEnd = matrix.lastIndex
        var columnEnd = matrix[0].lastIndex
        while (true) {
            for (i in columnStart..columnEnd) {
                matrix[rowStart][i] = matrixValue
                matrixValue++
                count++
            }
            rowStart++
            for (i in rowStart..rowEnd) {
                matrix[i][columnEnd] = matrixValue
                matrixValue++
                count++
            }
            columnEnd--
            if (size == count) {
                return matrix
            }
            for (i in columnEnd downTo  columnStart) {
                matrix[rowEnd][i] = matrixValue
                matrixValue++
                count++
            }
            rowEnd--
            for (i in rowEnd downTo  rowStart) {
                matrix[i][columnStart] = matrixValue
                matrixValue++
                count++
            }
            columnStart++
            if (size == count) {
                return matrix
            }
        }
    }

}

fun main() {
    val spiralMatrix = SpiralMatrix()
    spiralMatrix.generateMatrix(3)
        .forEach {
            ints ->
            ints.forEach {
                println(it)
            }
        }
}