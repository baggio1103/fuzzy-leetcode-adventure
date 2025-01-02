package dailyChallenge.year2025.january.january2

fun main() {
    println(
        vowelStrings(
            arrayOf("aba", "bcb", "ece", "aa", "e"),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(1, 1))
        ).contentToString()
    )
    println(
        vowelStrings(
            arrayOf("ab", "bcb", "ece", "aa", "e"),
            arrayOf(intArrayOf(0, 2), intArrayOf(1, 4), intArrayOf(2, 4))
        ).contentToString()
    )
}

fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val resultingArray = IntArray(queries.size)
    val prefixSum = IntArray(words.size)
    prefixSum[0] = if (vowels.contains(words[0].first()) && vowels.contains(words[0].last())) 1 else 0
    for (i in 1 until words.size) {
        val count = if (vowels.contains(words[i].first()) && vowels.contains(words[i].last())) 1 else 0
        prefixSum[i] = prefixSum[i - 1] + count
    }
    for ((index, range) in queries.withIndex()) {
        val (l, r) = range
        resultingArray[index] = prefixSum[r] - if (l == 0) 0 else prefixSum[l - 1]
    }
    return resultingArray
}