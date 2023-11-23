package dailyChallenge.november.november22


fun findDiagonalOrder(array: List<List<Int>>): IntArray {
    val diagonals = mutableListOf<MutableList<Int>>()
    array.forEachIndexed { rowIndex, row ->
        row.forEachIndexed { columnIndex, value ->
            val index = rowIndex + columnIndex
            if (index >= diagonals.size) {
                diagonals.add(mutableListOf())
            }
            diagonals[index].add(0, value)
        }
    }
    return diagonals.flatten().toIntArray()
}

fun main() {
    val array = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
    println(
        findDiagonalOrder(array).asList()
    )
    println(
        findDiagonalOrder(
            listOf(
                listOf(1, 2, 3, 4, 5), listOf(6, 7), listOf(8), listOf(9, 10, 11), listOf(12, 13, 14, 15, 16)
            )
        ).asList()
    )

    println(listOf(1, 6, 2, 8, 7, 3, 9, 4, 12, 10, 5, 13, 11, 14, 15, 16))

    println(
        findDiagonalOrder(
            listOf(
                listOf(14,12,19,16,9), listOf(13,14,15,8,11), listOf(11,13,1)
            )
        ).asList()
    )
}