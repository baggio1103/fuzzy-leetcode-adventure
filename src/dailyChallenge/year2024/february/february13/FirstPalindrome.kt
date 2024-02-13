package dailyChallenge.year2024.february.february13

fun firstPalindrome(words: Array<String>): String {
    for (word in words) {
        if (isPalindrome(word)) return word
    }
    return ""
}

fun isPalindrome(string: String, start: Int = 0, end: Int = string.lastIndex): Boolean {
    if (start > end) return true
    if (string[start] != string[end]) return false
    return isPalindrome(string, start + 1, end - 1)
}

fun main() {
    println(
        firstPalindrome(arrayOf("abc", "car", "ada", "racecar", "cool"))
    )
}