package dailyChallenge.december.december21

fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
    points.sortBy { it[0] }
    points.forEach {
        println(it.asList())
    }
    var max = points[1][0] - points[0][0]
    for (i in 2 until points.size) {
        val diff = points[i][0] - points[i - 1][0]
        if (diff > max) {
            max = diff
        }
    }
    return max
}

fun main() {
    println(
        maxWidthOfVerticalArea(
            arrayOf(
                intArrayOf(8, 7),
                intArrayOf(9, 9),
                intArrayOf(7, 4),
                intArrayOf(7, 9),
            )
        )
    )
    println(
        maxWidthOfVerticalArea(
            arrayOf(
                intArrayOf(3, 1),
                intArrayOf(9, 0),
                intArrayOf(1, 0),
                intArrayOf(5, 3),
                intArrayOf(1, 4),
                intArrayOf(8, 8),
            )
        )
    )
    println(
        maxWidthOfVerticalArea(
            arrayOf(
                intArrayOf(2, 4),
                intArrayOf(10, 10),
                intArrayOf(6, 8),
                intArrayOf(6, 8),
                intArrayOf(6, 10),
                intArrayOf(8, 6),
                intArrayOf(5, 3),
            )
        )
    )
}