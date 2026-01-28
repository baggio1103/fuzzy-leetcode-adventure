package bytebytego.intervals

fun main() {
    println(
        mergeOverlappingIntervals(
            arrayOf(
                intArrayOf(3, 4), intArrayOf(7, 8), intArrayOf(2, 5), intArrayOf(6, 7), intArrayOf(1, 4)
            )
        ).contentDeepToString()
    )
    println(
        mergeOverlappingIntervals(
            arrayOf(intArrayOf(1, 4), intArrayOf(4, 5))
        ).contentDeepToString()
    )
    println(
        mergeOverlappingIntervals(
            arrayOf(intArrayOf(4, 7), intArrayOf(1, 4))
        ).contentDeepToString()
    )
}

fun mergeOverlappingIntervals(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()
    intervals.sortBy { (start, _) -> start }
    result.add(intervals[0])
    var curr = 0
    for (i in 1 until intervals.size) {
        val (start, end) = result[curr]
        if (end >= intervals[i][0] && end <= intervals[i][1]) result[curr] = intArrayOf(start, intervals[i][1])
        if (end < intervals[i][0]) {
            result.add(intervals[i])
            curr++
        }
    }
    return result.toTypedArray()
}
