package dailyChallenge.year2024.march.march28

fun maxSubarrayLength(array: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var maxLength = 1
    var j = 0
    map[array[0]] = 1
    for (i in 1 until array.size) {
        val value = array[i]
        var count = (map[value] ?: 0) + 1
        map[value] = count
        while (count > k) {
            if (array[j] == value) {
                count--
            }
            val decr = map[array[j]] ?: 0
            map[array[j]] = decr - 1
            j++
        }
        maxLength = maxOf(maxLength, i - j + 1)
    }
    return maxLength
}

fun main() {
    println(
        maxSubarrayLength(
            intArrayOf(1, 2, 3, 1, 2, 3, 1, 2),
            2
        )
    )
    println(
        maxSubarrayLength(
            intArrayOf(1, 2, 1, 2, 1, 2, 1, 2),
            1
        )
    )
    println(
        maxSubarrayLength(
            intArrayOf(5, 5, 5, 5, 5, 5, 5),
            4
        )
    )
    println(
        maxSubarrayLength(
            intArrayOf(2, 2, 2, 3),
            1
        )
    )
    println(
        maxSubarrayLength(
            intArrayOf(1, 1, 1, 1, 2),
            2
        )
    )
    println(
        maxSubarrayLength(
            intArrayOf(1, 2, 2, 1, 3),
            1
        )
    )
}