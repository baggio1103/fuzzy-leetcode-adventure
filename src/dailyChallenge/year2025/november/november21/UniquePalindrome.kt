package dailyChallenge.year2025.november.november21

fun main() {
    println(countPalindromicSubsequence("aabca"))
    println(countPalindromicSubsequence("bbcbaba"))
}

fun countPalindromicSubsequence(string: String): Int {
    var count = 0
    for (letter in string.toSet()) {
        var left = -1
        var right = 0
        for ((index, char) in string.withIndex()) {
            if (char == letter && left == -1) left = index
            if (char == letter) right = index
        }
        val set = mutableSetOf<Char>()
        for (i in left + 1 until right) {
            set.add(string[i])
        }
        count += set.size
    }
    return count
}
