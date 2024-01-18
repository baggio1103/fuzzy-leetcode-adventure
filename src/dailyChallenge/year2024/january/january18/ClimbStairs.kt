package dailyChallenge.year2024.january.january18

fun climbStairs(n: Int, stair: Int = 0, cache: MutableMap<Int, Int> = mutableMapOf()): Int {
    val cached = cache[stair]
    if (cached != null) {
        return cached
    }
    if (stair == n) {
        return 1
    }
    if (stair > n) {
        return 0
    }
    val stepOne = climbStairs(n, stair + 1, cache)
    val stepTwo = climbStairs(n, stair + 2, cache)
    cache[stair] =  stepOne + stepTwo
    return stepOne + stepTwo
}

fun climbStairs(n: Int, cache: MutableMap<Int, Int> = mutableMapOf()): Int {
    val cached = cache[n]
    if (cached != null) {
        return cached
    }
    if (n == 0) {
        return 1
    }
    if (n < 0) {
        return 0
    }
    val oneStep = climbStairs(n - 1, cache)
    val twoStep = climbStairs(n - 2, cache)
    cache[n] = oneStep + twoStep
    return oneStep + twoStep
}

fun main() {
    println(
        climbStairs(3)
    )
    println(
        climbStairs(4)
    )
    println(
        climbStairs(45)
    )
}