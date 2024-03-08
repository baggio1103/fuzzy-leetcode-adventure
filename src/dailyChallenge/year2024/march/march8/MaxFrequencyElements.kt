package dailyChallenge.year2024.march.march8

fun maxFrequencyElements(array: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    array.forEach {
        val value = map[it] ?: 0
        map[it] = value + 1
    }
    val maxFrequency = map.maxBy { it.value }.value
    var count = 0
    map.forEach { (_, value) ->
        if (maxFrequency == value) {
            count += value
        }
    }
    return count
}

fun main() {
    println(
        maxFrequencyElements(
            intArrayOf(
                1, 2, 2, 3, 1, 4
            )
        )
    )
    println(
        maxFrequencyElements(
            intArrayOf(
                1, 2, 3, 4, 5
            )
        )
    )
}