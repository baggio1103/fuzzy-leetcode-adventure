package dailyChallenge.year2024.may.may1

fun reversePrefix(word: String, ch: Char): String {
    val index = word.indexOfFirst { it == ch }
    if (index == -1) return word
    return buildString {
        for (i in index downTo 0) append(word[i])
        for (i in index + 1 until word.length) append(word[i])
    }
}

fun main() {
    println(
        reversePrefix("abcdefd", 'd')
    )
    println(
        reversePrefix("xyxzxe", 'z')
    )
}