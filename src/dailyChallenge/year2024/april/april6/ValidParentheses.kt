package dailyChallenge.year2024.april.april6

import java.util.*

fun minRemoveToMakeValid(string: String): String {
    val stack = Stack<Int>()
    val result = buildString {
        for (i in string.indices) {
            val char = string[i]
            if (char == '(') {
                stack.push(length)
            }
            if (char == ')' && stack.size <= 0) {
                continue
            }
            if (char == ')') {
                stack.pop()
            }
            append(char)
        }
        repeat(stack.size) {
            val index = stack.pop()
            deleteCharAt(index)
        }
    }
    return result
}

fun main() {
    println(
        minRemoveToMakeValid("lee(t(c)o)de)")
    )
    println(
        minRemoveToMakeValid("a)b(c)d")
    )
    println(
        minRemoveToMakeValid("))((")
    )
}