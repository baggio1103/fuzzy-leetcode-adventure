package dailyChallenge.year2024.january.january4

fun minOperations(numbers: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    numbers.forEach { value ->
        val occurrence = map.getOrDefault(value, 0)
        map[value] = occurrence + 1
    }
    var minOperations = 0
    map.forEach { (_, occurrence) ->
        if (occurrence < 2) {
            return -1
        }
        val (div, remainder) = Pair(occurrence / 3, occurrence % 3)
        minOperations += if (remainder == 0) div else div + 1
    }
    return minOperations
}

fun main() {
    println(
        minOperations(
            intArrayOf(2,3,3,2,2,4,2,3,4)
        )
    )
    println(
        minOperations(
            intArrayOf(2, 1, 2, 2, 3, 3)
        )
    )
}