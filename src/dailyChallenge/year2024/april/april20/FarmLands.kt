package dailyChallenge.year2024.april.april20

fun findFarmland(land: Array<IntArray>): Array<IntArray> {
    val matrix = Array(land.size) {
        IntArray(land[0].size)
    }

    fun traverse(row: Int, column: Int, array: IntArray) {
        // visit
        matrix[row][column] = 1

        array[0] = minOf(array[0], row)
        array[1] = minOf(array[1], column)
        array[2] = maxOf(array[2], row)
        array[3] = maxOf(array[3], column)
        // left
        if (column - 1 in matrix[0].indices && matrix[row][column - 1] != 1 && land[row][column - 1] == 1) traverse(row, column - 1, array)

        // up
        if (row - 1 in matrix.indices && matrix[row - 1][column] != 1  && land[row][column - 1] == 1) traverse(row - 1, column, array)

        // right
        if (column + 1 in matrix[0].indices && matrix[row][column + 1] != 1  && land[row][column + 1] == 1) traverse(row, column + 1, array)

        // bottom
        if (row + 1 in matrix.indices && matrix[row + 1][column] != 1  && land[row + 1][column] == 1) traverse(row + 1, column, array)
    }

    val mutableArray = mutableListOf<IntArray>()
    for (row in land.indices) {
        for (column in land[0].indices) {
            if (land[row][column] == 1 && matrix[row][column] == 0) {
                val array = intArrayOf(row, column, row, column)
                traverse(row, column, array)
                mutableArray.add(array)
            } else matrix[row][column] = 1
        }
    }
    return mutableArray.toTypedArray()
}

fun main() {
    println(
        findFarmland(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
            )
        )
    )
    println(
        findFarmland(
            arrayOf(
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 1, 1, 1, 0),
                intArrayOf(0, 1, 1, 1, 0),
                intArrayOf(0, 0, 0, 0, 0),
                intArrayOf(0, 0, 0, 1, 1),
                intArrayOf(0, 0, 0, 1, 1),
            )
        )
    )
}