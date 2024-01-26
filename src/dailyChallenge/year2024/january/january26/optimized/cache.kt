package dailyChallenge.year2024.january.january26.optimized

private val mod = 1_000_000_007
fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int, cache: MutableMap<String, Int> = mutableMapOf()): Int {
    val key = "$maxMove-$startRow-$startColumn"
    val cached = cache[key]
    if (cached != null) {
        return cached
    }
    if (startRow >= m || startRow < 0) {
        cache[key] = 1
        return 1
    }
    if (startColumn >= n || startColumn < 0) {
        cache[key] = 1
        return 1
    }
    if (maxMove == 0) {
        cache[key] = 0
        return 0
    }
    val up = findPaths(m, n, maxMove - 1, startRow - 1, startColumn, cache)
    val down = findPaths(m, n, maxMove - 1, startRow + 1, startColumn, cache)
    val left = findPaths(m, n, maxMove - 1, startRow, startColumn - 1, cache)
    val right = findPaths(m, n, maxMove - 1, startRow, startColumn + 1, cache)
    var result = up
    result += down
    result %= mod
    result += left
    result %= mod
    result += right
    result %= mod
    cache[key] = result
    return result
}

fun main() {
    println(
        findPaths(
            2, 2, 2, 0, 0
        )
    )
    println(
        findPaths(1, 3, 3, 0, 1)
    )
    val value = findPaths(
        8, 50, 23, 5, 26
    )

    println(
        value % mod
    )
}