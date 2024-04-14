package hard.histogram

import java.util.Stack

fun largestRectangleArea(heights: IntArray): Int {
    // index, value
    val stack = Stack<Pair<Int, Int>>()
    var maxArea = 0
    for ((i, curValue) in heights.withIndex()) {
        var lastIndex: Int? = null
        while (stack.isNotEmpty() && stack.peek().second > curValue) {
           val (index, value) = stack.pop()
            val area = (i - index) * value
            maxArea = maxOf(maxArea, area)
            lastIndex = index
        }
        stack.push(Pair(lastIndex ?: i, curValue))
    }
    while (stack.isNotEmpty()) {
        val (index, value) = stack.pop()
        val area = (heights.size - index) * value
        maxArea = maxOf(maxArea, area)
    }
    return maxArea
}

fun main() {
    println(
        largestRectangleArea(
            heights = intArrayOf(1, 2, 3)
        )
    )
    println(
        largestRectangleArea(
            heights = intArrayOf(3, 2, 3)
        )
    )
    println(
        largestRectangleArea(
            intArrayOf(2, 1, 5, 6, 2, 3)
        )
    )
}