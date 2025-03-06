package dailyChallenge.year2025.march.march6

fun main() {
    println(
        findMissingAndRepeatedValues(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 2),
            )
        ).contentToString()
    )
}

fun findMissingAndRepeatedValues(grid: Array<IntArray>): IntArray {
    val size = grid.size
    val maxElement = size * size
    val map = mutableMapOf<Int, Int>()
    grid.forEach { row ->
        row.forEach { element ->
            val count = map[element] ?: 0
            map[element] = count + 1
        }
    }
    val result = IntArray(2)
    (1..maxElement).map { element ->
        val count = map[element]
        if (count == 2) {
            result[0] = element
        }
        if (count == null) {
            result[1] = element
        }
    }
    return result
}