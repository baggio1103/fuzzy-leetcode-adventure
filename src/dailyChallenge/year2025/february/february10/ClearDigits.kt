package dailyChallenge.year2025.february.february10

import java.util.ArrayDeque

fun main() {
    println(clearDigits("abc"))
    println(clearDigits("cb34"))
    println(clearDigits("ag3"))
}

fun clearDigitsByStack(string: String): String {
    val deque = ArrayDeque<Char>()
    for (char in string) {
        if (char.isDigit() && deque.isNotEmpty()) {
            deque.pop()
        } else deque.push(char)
    }
    return buildString {
        while (deque.isNotEmpty()) {
            append(deque.pollLast())
        }
    }
}

fun clearDigits(string: String): String {
    val chars = Array<Char?>(string.length) { string[it] }
    for ((i, char) in string.withIndex()) {
        if (char.isLetter()) {
            continue
        }
        chars[i] = null
        for (j in i - 1 downTo 0) {
            if (chars[j] != null && chars[j]?.isLetter() == true) {
                chars[j] = null
                break
            }
        }
    }
    return buildString {
        for (c in chars) {
            if (c != null) append(c)
        }
    }
}