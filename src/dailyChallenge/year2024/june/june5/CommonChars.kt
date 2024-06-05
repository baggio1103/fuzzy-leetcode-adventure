package dailyChallenge.year2024.june.june5

fun commonChars(words: Array<String>): List<String> {
    val wordMap = words.map { word ->
        word.groupingBy { it }.eachCount()
    }
    val allChars = (97..122).map { it.toChar() }
    val chars = words.map { it.toList() }.fold(allChars) { a, b ->
        a.intersect(b.toSet()).toMutableList()
    }
    val result = mutableListOf<String>()
    chars.forEach { ch ->
        var count = Int.MAX_VALUE
        wordMap.forEach { charMap ->
            count = minOf(count, charMap[ch] ?: -1)
        }
        repeat(count) {
            result.add(ch.toString())
        }
    }
    return result
}

fun main() {
    println(
        commonChars(
            words = arrayOf("bella", "label", "roller")
        )
    )
    println(
        commonChars(
            words = arrayOf("cool", "lock", "cook")
        )
    )
}
