package dailyChallenge.year2025.february.february3

fun main() {
//    println(
//        longestMonotonicSubarray(
//            array = intArrayOf(1, 4, 0, 1, 2, 3, 9, 10, 8, 7, 5, 4, 3, 2),
//        )
//    )
    println(longestMonotonicSubarray(intArrayOf(1, 4, 3, 3, 2)))
}

fun longestMonotonicSubarray(array: IntArray): Int {
    var max = 1
    var j = 0
    var y = 0
    for (i in 1 until array.size) {
        val current = array[i]
        val prev = array[i - 1]
        if (current > prev) { // monotonically increasing
            max = maxOf(max, i - j + 1)
            y = i
        } else if (current < prev) {
            max = maxOf(max, i - y + 1)
            j = i
        } else {
            j = i; y = i
        }
    }
    return max
}