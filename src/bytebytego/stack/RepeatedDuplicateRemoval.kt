package bytebytego.stack

import java.util.Stack

fun main() {
    println(repeatedDuplicateRemoval("aacabba"))
    println(repeatedDuplicateRemoval("aaa"))
    println(repeatedDuplicateRemoval("aaa"))
}

fun repeatedDuplicateRemoval(string: String): String {
    val stack = Stack<Char>()
    string.forEach { ch ->
        if (stack.isEmpty() || (stack.isNotEmpty() && stack.peek() != ch)) stack.push(ch)
        else stack.pop()
    }
    return buildString {
        while (stack.isNotEmpty()) {
            append(stack.pop())
        }
    }
}
