package dailyChallenge.year2025.january.january4

fun main() {
    println(countPalindromicSubsequence("aabca"))
    println(countPalindromicSubsequence("adc"))
    println(countPalindromicSubsequence("bbcbaba"))
}

fun countPalindromicSubsequence(string: String): Int {
    val letters = string.toSet()
    var count = 0
    for (letter in letters) {
        var i = -1
        var j = 0
        for (c in string.indices) {
            if (letter == string[c]) {
                if (i == -1) {
                    i = c
                }
                j = c
            }
        }
        val palindromes = mutableSetOf<Char>()
        for (c in i + 1 until j) {
            palindromes.add(string[c])
        }
        count += palindromes.size
    }
    return count
}