package dailyChallenge.year2024.april.april5

import java.util.ArrayDeque
import kotlin.math.absoluteValue

fun makeGood(string: String): String {
    val stack = ArrayDeque<Char>().apply { push(string[0]) }
    for (i in 1 until string.length) {
        if (stack.isNotEmpty() &&
            ((stack.peek() - string[i]).absoluteValue == 32)
        ) {
            stack.pop()
        } else
            stack.push(string[i])
    }
    return buildString {
        repeat(stack.size) {
            append(stack.pollLast())
        }
    }
}

fun main() {
    println(
        makeGood("leEeetcode")
    )
    println(
        makeGood("abBAcC")
    )
    println(
        makeGood("Pp")
    )
    println(
        makeGood("kkdsFuqUfSDKK")
    )
}