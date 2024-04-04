package dailyChallenge.year2024.april.april4

import java.util.Stack

fun maxDepth(string: String): Int {
    var maxDepth = 0
    var currentDepth = 0
    val stack = Stack<Char>()
    for (char in string) {
        if (char == '(') {
            stack.push(char)
            currentDepth++
            maxDepth = maxOf(maxDepth, currentDepth)
        }
        if (char == ')') {
            stack.pop()
            currentDepth--
        }
    }
    return maxDepth
}

fun main() {
    println(
        maxDepth("(1+(2*3)+((8)/4))+1")
    )
    println(
        maxDepth("(1)+((2))+(((3)))")
    )
}