package dailyChallenge.year2025.january.january7

fun main() {
  //  stringMatching(arrayOf("mass", "as", "hero", "superhero"))
    stringMatching(arrayOf("leetcoder", "leetcode", "od", "hamlet", "am"))
}

fun stringMatching(words: Array<String>): List<String> {
    val set = mutableSetOf<String>()
    words.sortBy { it.length }
    for ((index, word) in words.withIndex()) {
        for (i in index + 1 until words.size) {
            if (words[i].contains(word)) {
                set.add(word)
            }
        }
    }
    return set.toList().also(::println)
}