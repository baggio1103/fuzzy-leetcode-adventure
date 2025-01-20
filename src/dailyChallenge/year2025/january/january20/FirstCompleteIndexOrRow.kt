package dailyChallenge.year2025.january.january20

fun main() {
//    println(
//        firstCompleteIndex(
//            array = intArrayOf(1, 3, 4, 2),
//            matrix = arrayOf(
//                intArrayOf(1, 4),
//                intArrayOf(2, 3)
//            )
//        )
//    )

    println(
        firstCompleteIndex(
            array = intArrayOf(1, 4, 5, 2, 6, 3),
            matrix = arrayOf(
                intArrayOf(4, 3, 5),
                intArrayOf(1, 2, 6)
            )
        )
    )

}

fun firstCompleteIndex(array: IntArray, matrix: Array<IntArray>): Int {
    val rowSize = matrix.size
    val columnSize = matrix[0].size
    val columnMap = mutableMapOf<Int, Int>()
    val rowMap = mutableMapOf<Int, Int>()
    for (i in 0 until rowSize) {
        rowMap[i] = 0
    }
    for (i in 0 until columnSize) {
        columnMap[i] = 0
    }
    val indexesMap = mutableMapOf<Int, Pair<Int, Int>>()
    for (i in 0 until rowSize) {
        for (j in 0 until columnSize) {
            indexesMap[matrix[i][j]] = Pair(i, j)
        }
    }
    // Painting
    for ((index, value) in array.withIndex()) {
        val (i, j) = indexesMap[value] ?: return -1
        rowMap[i] = rowMap.getOrDefault(i, 0) + 1
        columnMap[j] = columnMap.getOrDefault(j, 0) + 1
        if (rowMap[i] == columnSize || columnMap[j] == rowSize) return index
    }
    return -1
}