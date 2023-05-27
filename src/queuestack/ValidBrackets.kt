package queuestack

import java.util.*

class ValidBrackets {

    fun isValid(input: String): Boolean {
        val closingBracketMap = mapOf(
            '(' to ')',
            '[' to ']',
            '{' to '}',
        )
        val stack = Stack<Char>()
        input.forEach { char ->
            if (char in listOf('(', '{', '[')) {
                stack.push(char)
            } else {
                if (stack.isEmpty()) {
                    return false
                }
                if (char != closingBracketMap[stack.peek()]) {
                    return false
                }
                stack.pop()
            }
        }
        return stack.isEmpty()
    }

}

fun main() {
    val validBrackets = ValidBrackets()
    println(
        validBrackets.isValid(
            "()"
        )
    )
    println(
        validBrackets.isValid(
            "()[]{}"
        )
    )
    println(
        validBrackets.isValid(
            "(]"
        )
    )
    println(
        validBrackets.isValid(
            "([{)}]"
        )
    )
    println(
        validBrackets.isValid(
            "()}}"
        )
    )
}