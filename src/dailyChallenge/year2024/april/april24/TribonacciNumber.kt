package dailyChallenge.year2024.april.april24

fun tribonacci(
    n: Int, cache: MutableMap<Int, Int> = mutableMapOf<Int, Int>().apply {
        this[0] = 0
        this[1] = 1
        this[2] = 1
    }
): Int {
    val value = cache[n]
    if (value != null) return value
    val result = tribonacci(n - 1, cache) + tribonacci(n - 2, cache) + tribonacci(n - 3, cache)
    cache[n] = result
    return result
}

fun main() {
    println(
        tribonacci(4)
    )
    println(
        tribonacci(25)
    )
}