package dailyChallenge.year2025.february.february11

import java.util.Stack

fun main() {
    println(
        removeOccurrences("daabcbaabcbc", "abc")
    )
    println(
        removeOccurrences("ababcc", "abc")
    )
}

fun removeOccurrences(string: String, part: String): String {
    val stack = Stack<Char>()
    for (char in string) {
        stack.push(char)
        if (stack.size >= part.length && checkMatch(Stack<Char>().apply { addAll(stack) }, part)) {
            repeat(part.length) { stack.pop() }
        }
    }
    return buildString {
        while (stack.isNotEmpty()) append(stack.pop())
    }.reversed()
}

fun checkMatch(stack: Stack<Char>, string: String): Boolean {
    for (i in string.lastIndex downTo 0) {
        if (stack.pop() != string[i]) {
            return false
        }
    }
    return true
}