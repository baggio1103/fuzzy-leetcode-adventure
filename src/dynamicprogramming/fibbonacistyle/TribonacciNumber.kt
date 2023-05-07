package dynamicprogramming.fibbonacistyle

import kotlin.IllegalArgumentException
import kotlin.system.measureTimeMillis

class TribonacciNumber {

    fun tribonacci(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1 || n == 2) {
            return 1
        }
        return tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1)
    }

    fun tribonnacciMemoized(
        n: Int,
        map: MutableMap<Int, Int> = mutableMapOf(0 to 0, 1 to 1, 2 to 1)
    ): Int {
        if (map.containsKey(n)) {
            return map[n] ?: throw IllegalArgumentException("Value cannot be null")
        }
        map[n] = tribonnacciMemoized(n - 3, map) + tribonnacciMemoized(n - 2, map) + tribonnacciMemoized(n - 1, map)
        return map[n] ?: throw IllegalArgumentException("Value cannot be null")
    }

}

fun main() {
    val tribonacciNumber = TribonacciNumber()
    println(
        tribonacciNumber.tribonacci(4)
    )
    measureTimeMillis {
        tribonacciNumber.tribonacci(36)
    }.let { println("Exec time for tribonacci(36): $it ms") }
    measureTimeMillis {
        tribonacciNumber.tribonnacciMemoized(36)
    }.let { println("Exec time for tribonnacciMemoized(36): $it ms") }
}