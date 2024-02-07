package dailyChallenge.year2024.february.february7.optimized

fun frequencySort(string: String): String {
    val charCount = string.groupingBy { it }.eachCount()
    val map = mutableMapOf<Int, MutableList<Char>>()
    for ((char, count) in charCount) {
        val chars = map[count]
        if (chars == null) {
            map[count] = mutableListOf(char)
            continue
        }
        chars.add(char)
    }
    return buildString {
        for (count in string.length downTo 1) {
            val chars = map[count] ?: continue
            chars.forEach { char ->
                repeat(count) {
                    append(char)
                }
            }
        }
    }
}

fun main() {
    println(
        frequencySort("tree")
    )
    println(
        frequencySort("cccaaa")
    )
    println(
        frequencySort("Aabb")
    )
}