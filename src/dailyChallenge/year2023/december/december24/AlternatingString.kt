package dailyChallenge.december.december24

import kotlin.math.min

fun minOperations(string: String): Int {
    val length = string.length
    val range = IntRange(0, length - 1)
    val a = buildString {
        for (i in 0 until length) {
            if (i % 2 == 0) {
                append('0')
            } else
                append('1')
        }
    }
    val b = buildString {
        for (i in 0 until length) {
            if (i % 2 == 0) {
                append('1')
            } else
                append('0')
        }
    }
    val aDiff = range.count {
        string[it] != a[it]
    }
    val bDiff = range.count {
        string[it] != b[it]
    }
    return min(aDiff, bDiff)
}

fun main() {
    println(
        minOperations("0100")
    )
    println(
        minOperations("10")
    )
}