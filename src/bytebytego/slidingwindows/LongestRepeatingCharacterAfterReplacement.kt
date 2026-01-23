package bytebytego.slidingwindows

fun main() {
    println(characterReplacement("aabcdcca", 2))
    println(characterReplacement("ABAB", 2))
    println(characterReplacement("AABABBA", 1))
}

fun characterReplacement(s: String, k: Int): Int {
    var length = 0
    var l = 0
    var r = 0
    val chars = mutableMapOf<Char, Int>()
    var highestFreq = 0
    while (r < s.length) {
        val char = s[r]
        chars[char] = chars.getOrDefault(char, 0) + 1
        highestFreq = maxOf(highestFreq, chars[char] ?: 0)
        val numbersToReplace = (r - l + 1) - highestFreq
        if (numbersToReplace > k) {
            chars[s[l]] = chars.getOrDefault(s[l], 0) - 1
            l++
        }
        length = maxOf(length, r - l + 1)
        r++
    }
    return length
}

