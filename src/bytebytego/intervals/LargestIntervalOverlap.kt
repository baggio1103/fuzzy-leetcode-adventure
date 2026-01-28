package bytebytego.intervals

fun main() {
    println(
        largestIntervalOverlap(
            arrayOf(
                intArrayOf(1, 3), intArrayOf(5, 7), intArrayOf(2, 6), intArrayOf(2, 4), intArrayOf(4, 8)
            )
        )
    )
}

fun largestIntervalOverlap(intervals: Array<IntArray>): Int {
    val points = mutableListOf<Pair<Int, Char>>()
    intervals.forEach { (start, end) ->
        points.add(start to 'S')
        points.add(end to 'E')
    }
    points.sortWith(compareBy<Pair<Int, Char>> { (start, _) -> start }.thenBy { (_, end) -> end })
    var maxOverlaps = 0
    var curr = 0
    for ((_, type) in points) {
        if (type == 'S')
            curr++
        else
            curr--
        maxOverlaps = maxOf(maxOverlaps, curr)
    }
    return maxOverlaps
}
