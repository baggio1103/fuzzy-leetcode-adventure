package dailyChallenge.year2025.january.january12

import java.util.*

fun main() {
    println(canBeValid(string = "))()))", locked = "010100"))
    println(canBeValid(string = ")(", locked = "00"))
    println(canBeValid(string = ")(()", locked = "0011"))
}

fun canBeValid(string: String, locked: String): Boolean {
    if (string.length % 2 == 1) return false
    val openBrackets = Stack<Int>()
    val unlocked = Stack<Int>()
    for (i in string.indices) {
        val char = string[i]
        if (locked[i] == '0') {
            unlocked.push(i)
            continue
        }
        if (char == '(') {
            openBrackets.push(i)
            continue
        }
        when {
            unlocked.isNotEmpty() -> unlocked.pop()
            openBrackets.isNotEmpty() -> openBrackets.pop()
            else -> return false
        }
    }
    while (openBrackets.isNotEmpty() && unlocked.isNotEmpty()
        && openBrackets.peek() < unlocked.peek()
    ) {
        openBrackets.pop()
        unlocked.pop()
    }
    return openBrackets.isEmpty()
}