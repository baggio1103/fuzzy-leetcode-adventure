package dailyChallenge.year2026.january.january3

fun main() {
    println(numOfWays(2))
    println(numOfWays(5000))
}

fun numOfWays(n: Int): Int {
    val mod = 1_000_000_007
    var a = 6L
    var b = 6L
    for (i in 2 .. n) {
        val newA = (2 * a + 2 * b) % mod
        val newB = (2 * a + 3 * b % mod)
        a = newA
        b = newB
    }
    return ((a + b) % mod).toInt()
}
