package dailyChallenge.november.november27


const val mod = 1000000007

fun knightDialer(n: Int): Int {
    var sum = 0
    IntRange(0, 9).forEach {
        val dial = knightDealer(n, length = 1, value = it)
        sum += dial
        sum %= mod
    }
    return sum
}

private fun knightDealer(
    n: Int,
    map: MutableMap<String, Int> = mutableMapOf(),
    length: Int,
    value: Int,
): Int {
    val key = "$length-$value"
    val memoized = map[key]
    if (memoized != null) {
        return memoized
    }
    if (length == n) {
        return 1
    }
    var sum = 0
    movements(value).forEach {
        val modulo = knightDealer(n, map, length + 1, it) % mod
        sum += modulo
        sum %= mod
    }
    map[key] = sum % mod
    return sum
}

private fun movements(cell: Int): List<Int> {
    return when (cell) {
        0 -> listOf(4, 6)
        1 -> listOf(6, 8)
        2 -> listOf(7, 9)
        3 -> listOf(4, 8)
        4 -> listOf(0, 3, 9)
        6 -> listOf(0, 1, 7)
        7 -> listOf(2, 6)
        8 -> listOf(1, 3)
        9 -> listOf(2, 4)
        else -> listOf()
    }
}

fun main() {
    println(
        knightDialer(3131)
    )
}