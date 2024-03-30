package dailyChallenge.year2024.march.march30

fun subarraysWithKDistinct(array: IntArray, k: Int): Int {

    fun count(array: IntArray, k: Int): Int {
        var count = 0
        // value -> count
        var j = 0
        val map = mutableMapOf<Int, Int>()
        for (i in array.indices) {
            val value = array[i]
            map[value] = (map[value] ?: 0) + 1
            while (map.size > k) {
                val leftValue = array[j]
                var leftValueCount = map[leftValue] ?: 1
                if (leftValueCount == 1) {
                    map.remove(leftValue)
                } else {
                    leftValueCount--
                    map[leftValue] = leftValueCount
                }
                j++
            }
            count += i - j + 1
        }
        return count
    }

    return count(array, k) - count(array, k - 1)
}

fun main() {
    println(
        subarraysWithKDistinct(
            intArrayOf(1, 2, 1, 2, 3),
            2
        )
    )
}
