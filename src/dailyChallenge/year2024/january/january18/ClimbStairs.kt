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

fun main() {
    println(
        climbStairs(45)
    )
    println(
        climbStairs(3)
    )
}