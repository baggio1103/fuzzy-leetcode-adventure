package contest343

class Solution {

    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = arr.size / m
        println("($m $n)")
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

    private fun findIndex(value: Int, matrix: Array<IntArray>): Pair<Int, Int> {
        matrix.forEachIndexed { outerIndex, ints ->
            ints.forEachIndexed { index, matrixValue ->
                if (matrixValue == value) {
                    return Pair(outerIndex, index)
                }
            }
        }
        return Pair(0, 0)
    }


}