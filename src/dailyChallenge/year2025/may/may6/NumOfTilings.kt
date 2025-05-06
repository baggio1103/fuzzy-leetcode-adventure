package dailyChallenge.year2025.may.may6

fun main() {
    println(numTilings(4))
}

fun numTilings(n: Int): Int {
    val mod = 1_000_000_007
    val cache = LongArray(1001)
    cache[1] = 1
    cache[2] = 2
    cache[3] = 5
    for (i in 4 .. n) {
        cache[i] = (2 * cache[i-1] + cache[i - 3]) % mod
    }
    return cache[n].toInt()
}