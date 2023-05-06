package dynamicprogramming.fibbonacistyle

import java.lang.IllegalArgumentException
import kotlin.system.measureTimeMillis

class FibonacciNumber {

    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return fib(n - 1) + fib(n - 2)
    }

    fun fibMemoized(n: Int, map: MutableMap<Int, Int> = mutableMapOf(0 to 0, 1 to 1)): Int {
        if (map.containsKey(n)) {
            return map[n] ?: throw IllegalArgumentException("Value cannot be null")
        }
        map[n] = fibMemoized(n - 1, map) + fibMemoized(n - 2, map)
        return map[n] ?: throw IllegalArgumentException("Value cannot be null")
    }
}

fun main() {
    val fibonacciNumber = FibonacciNumber()
    measureTimeMillis {
        println(
            fibonacciNumber.fib(15)
        )
        println(
            fibonacciNumber.fib(25)
        )
        println(
            fibonacciNumber.fib(35)
        )
        println(
            fibonacciNumber.fib(45)
        )
    }.let { println("Exec time of fibonacciSequence: $it") }
    println("=-=-=-=-=-=-=-=-=-=-=-=")
    measureTimeMillis {
        println(
            fibonacciNumber.fibMemoized(15)
        )
        println(
            fibonacciNumber.fibMemoized(25)
        )
        println(
            fibonacciNumber.fibMemoized(35)
        )
        println(
            fibonacciNumber.fibMemoized(45)
        )
    }.let {
        println("Exec time of fibonacciSequence with memoization: $it")
    }
}