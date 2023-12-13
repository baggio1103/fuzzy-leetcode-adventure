package dailyChallenge.december.december13

fun numSpecial(matrix: Array<IntArray>): Int {
    var result = 0
    matrix.forEach { row ->
        row.let { thisRow ->
            val count = thisRow.count { it == 1 }
            val (exists, index) = if (count != 1) {
                Pair(false, -1)
            } else
                Pair(true, thisRow.indexOf(1))
            if (!exists) {
                return@let
            }
            val columnCount = matrix.count { row ->
                row[index] == 1
            }
            if (columnCount == 1) {
                result++
            }
        }
    }
    return result
}

fun main() {
    println(
        numSpecial(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 0, 1),
                intArrayOf(1, 0, 0),
            )
        )
    )
    println(
        numSpecial(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 1),
            )
        )
    )
    println(
        numSpecial(
            arrayOf(
                intArrayOf(1, 0, 0),
                intArrayOf(0, 0, 1),
                intArrayOf(0, 0, 0),
            )
        )
    )

}
