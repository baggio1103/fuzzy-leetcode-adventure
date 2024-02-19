package dailyChallenge.year2024.february.february19

import kotlin.system.measureTimeMillis

fun isPowerOfTwo(n: Int): Boolean {
    if (n == 1) return true
    if (n % 2 != 0 || n <= 0) return false
    return isPowerOfTwo(n / 2)
}

fun isPowerOfTwoBitwise(number: Int): Boolean {
    if (number <= 0) return false
    val result = number.and(number - 1)
    return result == 0
}

fun main() {
    val recursionExecTime = measureTimeMillis {
        IntRange(1, 1_000_000_000).filter {
            isPowerOfTwo(it)
        }.forEach {
            println("Value: $it is power of 2")
        }
    }
    println("Recursion took $recursionExecTime ms\n")
    val bitwiseExecTime = measureTimeMillis {
        IntRange(1, 1_000_000_000).filter {
            isPowerOfTwoBitwise(it)
        }.forEach {
            println("Value: $it is power of 2")
        }
    }
    println("Bitwise took $bitwiseExecTime ms")
    val a = 7
    println(a.and(6))
}