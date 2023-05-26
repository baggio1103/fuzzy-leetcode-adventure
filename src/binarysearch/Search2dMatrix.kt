package binarysearch

import kotlin.math.min

class Search2dMatrix {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val index = binarySearchDown(matrix, target) ?: return true
        val array = matrix[index]
        var begin = 0
        var end = array.lastIndex
        while (begin <= end) {
            val middle = (begin + end) / 2
            if (array[middle] == target) {
                return true
            }
            if (array[middle] < target) {
                begin = middle + 1
            }
            if (array[middle] > target) {
                end = middle - 1
            }
        }
        return false
    }

    private fun binarySearchDown(matrix: Array<IntArray>, target: Int): Int? {
        var begin = 0
        var end = matrix.lastIndex
        val lastIndex = matrix[0].lastIndex
        while (begin <= end) {
            val middle = (begin + end) / 2
            if (matrix[middle][lastIndex] == target) {
                return null
            }
            if (matrix[middle][lastIndex] > target) {
                end = middle - 1
            }
            if (matrix[middle][lastIndex] < target) {
                begin = middle + 1
            }
        }
        return if (begin < 0) 0 else min(begin, matrix.lastIndex)
    }

}


fun main() {
    val search2dMatrix = Search2dMatrix()

    println(
        search2dMatrix.searchMatrix(arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23,30,34,60),
        ), 7)
    )

    println(
        search2dMatrix.searchMatrix(arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23,30,34,60),
        ), 3)
    )

    println(
        search2dMatrix.searchMatrix(
            arrayOf(
                intArrayOf(1, 1)
            ),
            11
        )
    )


}