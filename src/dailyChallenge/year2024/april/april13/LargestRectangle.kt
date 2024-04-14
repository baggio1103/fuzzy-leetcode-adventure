package dailyChallenge.year2024.april.april13

import hard.histogram.largestRectangleArea

fun maximalRectangle(matrix: Array<CharArray>): Int {
    val heights = IntArray(matrix[0].size)
    var maxArea = 0
    for (row in matrix) {
        for ((index, column) in row.withIndex()) {
            if (column == '0') {
                heights[index] = 0
            } else heights[index]++
        }
        println(heights.asList())
        maxArea = maxOf(maxArea, largestRectangleArea(heights))
    }
    return maxArea
}

fun main() {
    println(
        maximalRectangle(
            matrix = arrayOf(
                charArrayOf('1', '0', '1', '0', '0'),
                charArrayOf('1', '0', '1', '1', '1'),
                charArrayOf('1', '1', '1', '1', '1'),
                charArrayOf('1', '0', '0', '1', '0'),
            )
        )
    )
}