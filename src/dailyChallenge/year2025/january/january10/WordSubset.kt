package dailyChallenge.year2025.january.january10

fun main() {
    wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("e", "o"))
        .also(::println)
}

fun wordSubsets(arrayOne: Array<String>, arrayTwo: Array<String>): List<String> {
    val charMaxCount = mutableMapOf<Char, Int>()
    for (word in arrayTwo) {
        val map = word.groupingBy { it }.eachCount()
        map.forEach { (char, count) ->
            charMaxCount[char] = maxOf(count, charMaxCount[char] ?: 0)
        }
    }
    val universalWords = mutableListOf<String>()
    arrayOne.forEach { word ->
        val universalWordMap = word.groupingBy { it }.eachCount()
        if (areSame(universalWordMap, charMaxCount)) universalWords.add(word)
    }
    return universalWords
}

fun areSame(mapOne: Map<Char, Int>, mapTwo: Map<Char, Int>): Boolean {
    mapTwo.forEach { (char, count) ->
        val universalWordCharCount = mapOne[char]
        if (universalWordCharCount == null || universalWordCharCount < count) return false
    }
    return true
}