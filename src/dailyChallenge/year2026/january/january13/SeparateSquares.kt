package dailyChallenge.year2026.january.january13

fun main() {
    println(
        separateSquares(
            arrayOf(
                intArrayOf(0, 0, 2), intArrayOf(1, 1, 1)
            )
        )
    )
}

fun separateSquares(squares: Array<IntArray>): Double {
    var totalArea = 0.0
    var low = Double.POSITIVE_INFINITY
    var high = Double.NEGATIVE_INFINITY
    for ((_, y, l) in squares) {
        totalArea += l.toDouble() * l
        low = minOf(low, y.toDouble())
        high = maxOf(high, (y + l).toDouble())
    }

    val targetArea = totalArea / 2

    fun area(line: Double): Double {
        var area = 0.0
        for ((_, y, l) in squares) {
            area += when {
                line <= y.toDouble() -> continue
                line >= y + l -> (l.toDouble() * l)
                else -> (l * (line - y))
            }
        }
        return area
    }

    repeat(60) {
        val mid = (low + high) / 2
        if (area(mid) < targetArea) {
            low = mid
        } else
            high = mid
    }
    return (low + high) / 2.0
}
