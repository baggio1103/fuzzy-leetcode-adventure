package dailyChallenge.december.december25.memo

import kotlin.system.measureTimeMillis

val map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".mapIndexed { index, char ->
    Pair("${index + 1}", char)
}.toMap()

fun numDecodings(string: String): Int {
    if (string[0] == '0') {
        return 0
    }
    if (string.length == 1) {
        return 1
    }
    if (string.length > 2) {
        return numDecodings(string, IntRange(0, 0)) + numDecodings(string, IntRange(0, 1))
    }
    val value = string.toInt()
    if (value > 26 && value % 10 == 0) {
        return 0
    }
    return if (value > 26 || value == 10 || value == 20) 1 else 2
}


fun numDecodings(
    string: String,
    range: IntRange = IntRange(0, 0),
    memo: MutableMap<IntRange, Int> = mutableMapOf()
): Int {
    if (memo[range] != null) {
        return memo[range]!!
    }
    val index = range.last
    if (index > string.lastIndex) {
        return 0
    }
    val value = string.substring(range)
    if (map[value] == null) {
        return 0
    }
    if (index == string.lastIndex && value[0] != '0') {
        return 1
    }
    val (leftRange, rightRange) = Pair(IntRange(index + 1, index + 1), IntRange(index + 1, index + 2))
    val left = numDecodings(string, leftRange, memo)
    val right = numDecodings(string, rightRange, memo)
    memo[leftRange] = left
    memo[rightRange] = right
    return left + right
}

fun main() {
    println(
        "Time to exec: ${
            measureTimeMillis {
                numDecodings("111111111111111111111111111111111111111111111")
            }
        }"
    )
    println(
        numDecodings("111111111111111111111111111111111111111111111")
    )
    println(
        numDecodings("20")
    )
    println(numDecodings("30"))
    println(numDecodings("27"))
}