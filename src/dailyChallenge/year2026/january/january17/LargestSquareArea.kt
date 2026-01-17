package dailyChallenge.year2026.january.january17

fun main() {
    println(
        largestSquareArea(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 1)
            ),
            arrayOf(
                intArrayOf(3, 3), intArrayOf(4, 4), intArrayOf(6, 6)
            ),
        )
    )
}

fun largestSquareArea(bottomLeft: Array<IntArray>, topRight: Array<IntArray>): Long {
    var maxSide = 0
    for (i in bottomLeft.indices) {
        val (x1, y1) = bottomLeft[i]
        val (x2, y2) = topRight[i]
        for (j in i + 1 until topRight.size) {
            val (x3, y3) = bottomLeft[j]
            val (x4, y4) = topRight[j]
            val width = minOf(x2, x4) - maxOf(x1, x3)
            val height = minOf(y2, y4) - maxOf(y1, y3)
            if (width > 0 && height > 0) {
                val side = minOf(width, height)
                maxSide = maxOf(maxSide, side)
            }
        }
    }
    return maxSide.toLong() * maxSide
}
