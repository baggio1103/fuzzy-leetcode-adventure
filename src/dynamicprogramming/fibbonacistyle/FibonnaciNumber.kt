package dynamicprogramming.fibbonacistyle

class FibonacciNumber {

    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        return fib(n - 1) + fib(n - 2)
    }

}

fun main() {
    val fibonacciNumber = FibonacciNumber()
    println(
        fibonacciNumber.fib(10)
    )
    println(
        fibonacciNumber.fib(30)
    )
}