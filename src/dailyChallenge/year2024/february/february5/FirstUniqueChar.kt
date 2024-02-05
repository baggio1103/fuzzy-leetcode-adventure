package dailyChallenge.year2024.february.february5

fun firstUniqueChar(string: String): Int {
    val char = string.groupingBy { it }.eachCount()
        .entries
        .firstOrNull {
            it.value == 1
        }?.key ?: return -1
    return string.indexOfFirst { it == char }
}

fun main() {
    println(
        firstUniqueChar("leetcode")
    )
    println(
        firstUniqueChar("loveleetcode")
    )
    println(
        firstUniqueChar("aabb")
    )
}