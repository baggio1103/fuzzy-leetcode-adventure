package dailyChallenge.year2024.march.march11

fun customSortString(order: String, string: String): String {
    return buildString {
        val charMap = string.groupingBy { it }.eachCount().toMutableMap()
        order.forEach { ch ->
            repeat(charMap[ch] ?: 0) {
                append(ch)
            }
            charMap.remove(ch)
        }
        charMap.forEach { (char, count) ->
            repeat(count) {
                append(char)
            }
        }
    }
}

fun main() {
    println(
        customSortString(
            "kqep", "pekeq"
        )
    )
    println(
        customSortString(
            "cba", "abcd"
        )
    )
    println(
        customSortString(
            "bcafg", "abcd"
        )
    )
}