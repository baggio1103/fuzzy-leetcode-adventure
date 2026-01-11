package dailyChallenge.year2026.january.january11

import java.util.Stack

fun main() {
//    println(
//        maximalRectangle(
//            matrix = arrayOf(
//                charArrayOf('1', '0', '1', '0', '0'),
//                charArrayOf('1', '0', '1', '1', '1'),
//                charArrayOf('1', '1', '1', '1', '1'),
//                charArrayOf('1', '0', '0', '1', '0'),
//            )
//        )
//    )

//    println(largestArea(intArrayOf(3, 1, 3, 2, 2, 0)))
//    println(largestArea(intArrayOf(2, 1, 5, 6, 2, 0)))
    println(largestArea(intArrayOf(3, 0, 2, 2, 0)))
}

fun maximalRectangle(matrix: Array<CharArray>): Int {
    val rows = matrix.size
    val columns = matrix[0].size
    val heights = IntArray(columns + 1)
    var maxRectangle = 0
    for (i in 0 until rows) {
        for (j in 0 until columns) {
            if (matrix[i][j] == '1') heights[j]++ else heights[j] = 0
        }
        maxRectangle = maxOf(maxRectangle, largestArea(heights))
    }
    return maxRectangle
}

fun largestArea(heights: IntArray): Int {
    val stack = Stack<Int>()
    var area = 0
    for (i in heights.indices) {
        while (stack.isNotEmpty() && heights[i] < heights[stack.peek()]) {
            val height = heights[stack.pop()]
            val width = if (stack.isEmpty()) i else i - stack.peek() - 1
            area = maxOf(area, height * width)
        }
        stack.push(i)
    }
    return area
}
