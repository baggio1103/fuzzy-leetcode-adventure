package contest343

import java.lang.IllegalArgumentException

class MatrixOptimized {

    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val rowSize = mat.size
        val columnSize = arr.size / rowSize
        val matrixIndices = mutableMapOf<Int, Pair<Int, Int>>()
        mat.forEachIndexed { row, ints ->
            ints.forEachIndexed { column, value ->
                matrixIndices[value] = Pair(row, column)
            }
        }
        val indexValueMap = mutableMapOf<String, Int>()
        arr.forEachIndexed { index, value ->
            val (row, column) = matrixIndices[value] ?: throw IllegalArgumentException()
            val rowKey = "row-$row"
            val columnKey = "col:$column"
            if (indexValueMap.containsKey(rowKey)) {
                val currentValue = indexValueMap[rowKey]
                indexValueMap[rowKey] = currentValue?.inc() ?: throw IllegalArgumentException()
            } else {
                indexValueMap[rowKey] = 1
            }
            if (indexValueMap.containsKey(columnKey)) {
                val currentValue = indexValueMap[columnKey]
                indexValueMap[columnKey] = currentValue?.inc() ?: throw IllegalArgumentException()
            } else {
                indexValueMap[columnKey] = 1
            }
            indexValueMap[rowKey]?.let {
                if (it == columnSize) {
                    return index
                }
            }
            indexValueMap[columnKey]?.let {
                if (it == rowSize) {
                    return index
                }
            }

        }
        return 0
    }

}

fun main() {
    val matrixSolver = MatrixOptimized()
    val matrix = arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
    println(matrixSolver.firstCompleteIndex(intArrayOf(1, 3, 4, 2), matrix))

    val matrixTwo = arrayOf(intArrayOf(3,2,5), intArrayOf(1,4,6), intArrayOf(8,7,9))
    println(matrixSolver.firstCompleteIndex(intArrayOf(2,8,7,4,1,3,5,6,9), matrixTwo))

    val matrixThree = arrayOf(intArrayOf(4,3,5), intArrayOf(1, 2, 6))
    println(matrixSolver.firstCompleteIndex(intArrayOf(1,4,5,2,6,3), matrixThree))

}