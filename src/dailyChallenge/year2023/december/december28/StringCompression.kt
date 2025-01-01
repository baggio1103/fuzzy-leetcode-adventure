package dailyChallenge.december.december28

import kotlin.math.min

fun getLengthOfOptimalCompression(string: String, k: Int): Int {
    return count(string, 0, k, ' ', 0)
}

fun count(string: String, index: Int, deletionCount: Int, prevChar: Char, prevCount: Int, cache: MutableMap<String, Int> = mutableMapOf()): Int {
    val key = "$index-$deletionCount-$prevChar-$prevCount"
    if (cache[key] != null) {
        return cache[key] ?: 0
    }
    if (deletionCount < 0) {
        return Int.MAX_VALUE
    }
    if (index == string.length) {
        return 0
    }
    val result = if (string[index] == prevChar) {
        val increment = if (prevCount in listOf(1, 9, 99)) 1 else 0
        increment + count(string, index + 1, deletionCount, prevChar, prevCount + 1, cache)
    } else
        min(
            // Delete
            count(string, index + 1, deletionCount - 1, prevChar, prevCount, cache),
            // Not delete
            1 + count(string, index + 1, deletionCount, string[index], 1, cache)
        )
    cache[key] = result
    return result
}

fun main() {
    println(
        getLengthOfOptimalCompression("aaabbaaadfe", 3)
    )
}