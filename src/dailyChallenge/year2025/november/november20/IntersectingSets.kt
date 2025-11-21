package dailyChallenge.year2025.november.november20

fun main() {
    println(
        intersectionSizeTwo(
            arrayOf(intArrayOf(1, 3), intArrayOf(3, 7), intArrayOf(8, 9))
        )
    )
    println(
        intersectionSizeTwo(
            arrayOf(intArrayOf(1, 3), intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(3, 5))
        )
    )
    println(
        intersectionSizeTwo(
            arrayOf(intArrayOf(2, 99), intArrayOf(1, 100), intArrayOf(1, 99))
        )
    )
}

fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
    var result = 0
    intervals.sortWith { a, b -> if (a[1] != b[1]) a[1] - b[1] else b[0] - a[0] }
    var left = -1
    var right = -1
    for ((start, end) in intervals) {
        when {
            left >= start -> continue
            right >= start -> {
                result += 1
                left = right
                right = end
            }

            else -> {
                result += 2
                right = end
                left = right - 1
            }
        }
    }
    return result
}
