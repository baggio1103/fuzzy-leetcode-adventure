package dailyChallenge.december.december3

import kotlin.math.abs
import kotlin.math.max

fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
    var seconds = 0
    for (it in 1 until points.size) {
        seconds += max(
            abs(points[it][0] - points[it - 1][0]),
            abs(points[it][1] - points[it - 1][1])
        )
    }
    return seconds
}

fun main() {

    println(
        minTimeToVisitAllPoints(
            arrayOf(intArrayOf(1, 1), intArrayOf(3, 4), intArrayOf(-1, 0))
        )
    )
    println(
        minTimeToVisitAllPoints(
            arrayOf(
                intArrayOf(3, 2), intArrayOf(-2, 2)
            )
        )
    )
    println(
        minTimeToVisitAllPoints(arrayOf(
            intArrayOf(0, 0), intArrayOf(-4, -5)
        ))
    )
    println(
        minTimeToVisitAllPoints(
            array
        )
    )



}

