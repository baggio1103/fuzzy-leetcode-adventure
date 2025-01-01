package dailyChallenge.december.december25

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
    return if (value > 26 || value == 10) 1 else 2
}


fun numDecodings(string: String, range: IntRange = IntRange(0, 0)): Int {
    val index = range.last
    if (index > string.lastIndex) {
        return 0
    }
    val value = string.substring(range)
    if (map[value] == null) {
        return 0
    }
    if (index == string.lastIndex || index == string.lastIndex -1  && value[0] != '0') {
        return 1
    }
    val left = numDecodings(string, IntRange(index + 1, index + 1))
    val right = numDecodings(string, IntRange(index + 1, index + 2))
    return left + right
}

fun main() {
//    println(
//        numDecodings("296")
//    )
//    println(
//        numDecodings("11106")
//    )
//    println(
//        numDecodings("27")
//    )
    println(
        numDecodings("1201234")
    )
    println(
        "Time to exec: ${
            measureTimeMillis {
                println(
                    numDecodings("111111111111111111111111111111111111111111111")
                )
            }
        }"
    )
}

