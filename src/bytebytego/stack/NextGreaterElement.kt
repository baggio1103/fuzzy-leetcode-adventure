package bytebytego.stack

import java.util.Stack

fun main() {
    println(nextGreaterElements(intArrayOf(5, 2, 4, 6, 1)).contentToString())
}

fun nextGreaterElements(array: IntArray): IntArray {
    val result = IntArray(array.size) { -1 }
    val stack = Stack<Int>()
    for (i in array.lastIndex downTo 0) {
        val number = array[i]
        while (stack.isNotEmpty() && stack.peek() < number) {
            stack.pop()
        }
        result[i] = if (stack.isNotEmpty()) stack.peek() else -1
        stack.push(number)
    }
    return result
}
