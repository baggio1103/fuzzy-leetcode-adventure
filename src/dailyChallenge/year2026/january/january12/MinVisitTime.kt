package dailyChallenge.year2026.january.january12

import kotlin.math.abs

fun main() {
    println(
        minTimeToVisitAllPoints(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0)
            )
        )
    )
}

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var time = 0
    for (i in 1 until points.size) {
        val (x1, y1) = points[i - 1]
        val (x2, y2) = points[i]
        time += maxOf(abs(x1 - x2), abs(y1 - y2))
    }
    return time
}
