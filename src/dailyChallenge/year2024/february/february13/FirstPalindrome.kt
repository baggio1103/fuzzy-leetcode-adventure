package dailyChallenge.year2024.february.february13

fun firstPalindrome(words: Array<String>): String {
    return words.firstOrNull { isPalindrome(it) } ?: ""
}

fun isPalindrome(string: String, start: Int = 0, end: Int = string.lastIndex): Boolean {
    if (start > end) {
        return true
    }
    return string[start] == string[end] && isPalindrome(string, start + 1, end - 1)
}

fun main() {
    println(
        firstPalindrome(arrayOf("abc", "car", "ada", "racecar", "cool"))
    )
}