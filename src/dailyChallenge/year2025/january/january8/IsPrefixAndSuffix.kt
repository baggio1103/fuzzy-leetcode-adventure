package dailyChallenge.year2025.january.january8

fun main() {
    println(
        countPrefixSuffixPairs(words = arrayOf("a", "aba", "ababa", "aa"))
    )
    println(
        countPrefixSuffixPairs(words = arrayOf("pa", "papa", "ma", "mama"))
    )
    println(
        countPrefixSuffixPairs(words = arrayOf("abab", "ab"))
    )
}

fun countPrefixSuffixPairs(words: Array<String>): Int {
    var counter = 0
    for ((index, word) in words.withIndex()) {
        for (i in index + 1 until words.size) {
            if (isPrefixAndSuffix(word, words[i])) counter++
        }
    }
    return counter
}

fun isPrefixAndSuffix(wordOne: String, wordTwo: String): Boolean {
    if (wordOne.length >= wordTwo.length) return false
    for ((index, char) in wordOne.withIndex()) {
        val charOne = wordTwo[index]
        val charTwo = wordTwo[wordTwo.length - wordOne.length + index]
        if (char != charOne || charOne != charTwo) return false
    }
    return true
}