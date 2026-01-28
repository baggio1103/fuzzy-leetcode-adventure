package bytebytego.stack

import java.util.Stack

fun main() {
    println(isValid("()"))
    println(isValid("()[]{}"))
    println(isValid("()[]}{"))
    println(isValid(")([]}{"))
}

fun isValid(string: String): Boolean {
    val parentheses = mutableMapOf('(' to ')', '{' to '}', '[' to ']')
    val stack = Stack<Char>()
    string.forEach { ch ->
        if (ch in parentheses) stack.push(ch)
        else
            if (stack.isEmpty() || ch != parentheses[stack.pop()]) return false
    }
    return stack.isEmpty()
}
