package dailyChallenge.year2024.april.april7

import java.util.Stack

fun checkValidString(string: String): Boolean {
    val stack = Stack<Int>()
    val asterisks = Stack<Int>()
    string.forEachIndexed { index, char ->
        when (char) {
            '*' -> asterisks.push(index)
            '(' -> stack.push(index)
            ')' -> {
                if (stack.isNotEmpty()) {
                    stack.pop()
                } else if (stack.isEmpty() && asterisks.isNotEmpty()) {
                    asterisks.pop()
                } else {
                    return false
                }
            }
        }
    }
    while (stack.isNotEmpty() && asterisks.isNotEmpty()) {
        val brInd = stack.pop()
        val astIndex = asterisks.pop()
        if (brInd > astIndex) return false
    }
    return stack.isEmpty()
}

fun main() {
    println(
        checkValidString("()")
    )
    println(
        checkValidString("(*)")
    )
    println(
        checkValidString("(*))")
    )
    println(
        checkValidString(
            "()()()((((()((()(()())(()))(())))((()((()())*(((())()))(()((())(((((((())()*)())((())*))))*)())()))"
        )
    )
    println(
        checkValidString("(((()***())")
    )
    println(
        checkValidString("(((()***())(")
    )
}