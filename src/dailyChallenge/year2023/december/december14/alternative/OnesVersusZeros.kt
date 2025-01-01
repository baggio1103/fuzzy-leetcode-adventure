package dailyChallenge.december.december14.alternative

fun onesMinusZeros(grid: Array<IntArray>): Array<IntArray> {
    val rows = grid.size
    val columns = grid[0].size
    val array = Array(rows) {
        IntArray(columns)
    }
    val rowMap = mutableMapOf<Int, Pair<Int, Int>>()
    val columnMap = mutableMapOf<Int, Pair<Int, Int>>()
    IntRange(0, rows - 1).forEach { rowIndex ->
        IntRange(0, columns - 1).forEach { columnIndex ->
            val (rowOnes, rowZeros) = if (rowMap[rowIndex] != null) {
                rowMap[rowIndex]!!
            } else {
                val result = onesAndZeros(grid[rowIndex])
                rowMap[rowIndex] = result
                result
            }
            val (columnOnes, columnZeros) = if (columnMap[columnIndex] != null) {
                columnMap[columnIndex]!!
            } else {
                var columnOnes = 0
                var columnZeros = 0
                grid.forEach { if (it[columnIndex] == 0) {
                    columnZeros++
                } else
                    columnOnes++
                }
                columnMap[columnIndex] = Pair(columnOnes, columnZeros)
                Pair(columnOnes, columnZeros)
            }
            array[rowIndex][columnIndex] = rowOnes + columnOnes - rowZeros - columnZeros
        }
    }
    return array
}

fun onesAndZeros(intArray: IntArray): Pair<Int, Int> {
    var zeros = 0
    var ones = 0
    intArray.forEach {
        if (it == 0) {
            zeros++
        } else
            ones++
    }
    return Pair(ones, zeros)
}

