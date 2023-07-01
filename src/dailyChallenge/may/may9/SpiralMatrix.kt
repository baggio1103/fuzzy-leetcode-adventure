package dailyChallenge.may9

class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val rowCount = matrix.size
        val columnCount = matrix[0].size
        val size = rowCount * columnCount
        val list = mutableListOf<Int>()
        var rowStart = 0
        var columnStart = 0
        var rowEnd = matrix.lastIndex
        var columnEnd = matrix[0].lastIndex
        while (true) {
            for (i in columnStart..columnEnd) {
                list.add(matrix[rowStart][i])
            }
            rowStart++
            for (i in rowStart..rowEnd) {
                list.add(matrix[i][columnEnd])
            }
            columnEnd--
            if (list.size == size) {
                return list
            }
            for (i in columnEnd downTo  columnStart) {
                list.add(matrix[rowEnd][i])
            }
            rowEnd--
            for (i in rowEnd downTo  rowStart) {
                list.add(matrix[i][columnStart])
            }
            columnStart++
            if (list.size == size) {
                return list
            }
        }
    }

}

fun main() {
    val spiralMatrix = SpiralMatrix()
    println(
        spiralMatrix.spiralOrder(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 4)
            )
        )
    )
    println(
        spiralMatrix.spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
        )
    )
    println(
        spiralMatrix.spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
            )
        )
    )
}