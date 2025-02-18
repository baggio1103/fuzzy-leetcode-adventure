package dailyChallenge.year2025.february.february18

import java.util.*

fun main() {
    println(
        smallestNumber("IIIDIDDD")
    )
}

fun smallestNumber(pattern: String): String = buildString {
    val stack = Stack<Int>()
    for (index in 0 .. pattern.length) {
        stack.push(index + 1)
        if (index == pattern.length || pattern[index] == 'I') {
            while (stack.isNotEmpty()) {
                append(stack.pop())
            }
        }
    }
}
