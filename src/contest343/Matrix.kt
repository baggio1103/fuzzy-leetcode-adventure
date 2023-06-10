package contest343

fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
    val m = mat.size
    val n = arr.size / m
    val emptyMatrix = List(m) {
        List(n) { _ ->
            -1
        }.toIntArray()
    }.toTypedArray()
    arr.forEachIndexed { index, value ->
        val (row, column) = findIndex(value, mat)
        emptyMatrix[row][column] = value
        if (emptyMatrix[row].all {
                it != -1
            }
            ) {
            return index
        }
        if (
            IntRange(0, m - 1).all {
                emptyMatrix[it][column] != -1
            }
        ) {
            return index
        }
    }
    emptyMatrix.forEach { ints ->
        ints.forEach {
            println(it)
        }
    }
    return 0
}

fun findIndex(value: Int, matrix: Array<IntArray>): Pair<Int, Int> {
    matrix.forEachIndexed { outerIndex, ints ->
        ints.forEachIndexed { index, matrixValue ->
            if (matrixValue == value) {
                return Pair(outerIndex, index)
            }
        }
    }
    return Pair(-1, -1)
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
    println(firstCompleteIndex(intArrayOf(1, 3, 4, 2), matrix))

    val matrixTwo = arrayOf(intArrayOf(3,2,5), intArrayOf(1,4,6), intArrayOf(8,7,9))
    println(firstCompleteIndex(intArrayOf(2,8,7,4,1,3,5,6,9), matrixTwo))
    println(findIndex(7, matrixTwo))
}
