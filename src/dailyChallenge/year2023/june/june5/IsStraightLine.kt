package dailyChallenge.june.june5

import kotlin.math.absoluteValue

class IsStraightLine {

    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        var xConstant = 0
        var yConstant = 0
        val x = coordinates[0][0].absoluteValue
        val y = coordinates[0][1].absoluteValue
        coordinates.forEach { values ->
            if (x == values[0].absoluteValue) {
                xConstant++
            }
            if (y == values[1].absoluteValue) {
                yConstant++
            }
        }
        if (xConstant == coordinates.size || yConstant == coordinates.size) {
            return true
        }
        val init = coordinates[0]
        val next = coordinates[1]
        val relation = (next[0] - init[0]).div((next[1] - init[1]).toDouble())
        for (i in 1 until coordinates.lastIndex) {
            val currentRelation = (coordinates[i + 1][0] - coordinates[i][0])
                .div((coordinates[i + 1][1] - coordinates[i][1]).toDouble())
            if (relation != currentRelation) {
                return false
            }
        }
        return true
    }

}

fun main() {
    val straightLine = IsStraightLine()


    println(
        straightLine.checkStraightLine(
            arrayOf(
                intArrayOf(1, -8),
                intArrayOf(2, -3),
                intArrayOf(1, 2)
            )
        )
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        straightLine.checkStraightLine(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(3, 2),
                intArrayOf(6, 4),
            )
        )
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        straightLine.checkStraightLine(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7),
            )
        )
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        straightLine.checkStraightLine(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(5, 6),
                intArrayOf(7, 7),
            )
        )
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        straightLine.checkStraightLine(
            arrayOf(
                intArrayOf(-3, -2),
                intArrayOf(-1, -2),
                intArrayOf(2, -2),
                intArrayOf(-2, -2),
                intArrayOf(0, 2),
            )
        )
    )

    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        straightLine.checkStraightLine(
            arrayOf(
                intArrayOf(-2, 12),
                intArrayOf(2, -8),
                intArrayOf(6, -28),
                intArrayOf(-10, 52),
                intArrayOf(-7, 37),
                intArrayOf(4, -18),
                intArrayOf(7, -33),
                intArrayOf(1, -3),
                intArrayOf(-1, 7),
                intArrayOf(8, -38),
            )
        )
    )

}