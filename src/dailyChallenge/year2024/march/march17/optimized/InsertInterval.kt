package dailyChallenge.year2024.march.march17.optimized

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    var i = 0
    while (i < intervals.size && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i])
        i++
    }

    while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
        newInterval[0] = minOf(intervals[i][0], newInterval[0])
        newInterval[1] = maxOf(intervals[i][1], newInterval[1])
        i++
    }
    result.add(newInterval)
    while (i < intervals.size) {
        result.add(intervals[i])
        i++
    }
    result.forEach { println(it.asList()) }
    return result.toTypedArray()
}

fun main() {
    insert(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9)
        ),
        intArrayOf(0, 5)
    )
    println()
    insert(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9)
        ),
        intArrayOf(6, 10)
    )
    println()
}