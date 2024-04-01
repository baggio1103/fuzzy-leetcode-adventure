package slidingwindow

fun lengthOfLongestSubstring(string: String): Int {
    var j = 0
    var length = 0
    val map = mutableMapOf<Char, Int>()
    for (i in string.indices) {
        val char = string[i]
        val count = map[char] ?: 0
        map[char] = count + 1
        while (map.getOrDefault(char, 0) > 1) {
            val dec = map[string[j]] ?: 0
            map[string[j]] = dec - 1
            j++
        }
        length = maxOf(length, i - j + 1)
    }
    return length
}

fun main() {
    println(
        lengthOfLongestSubstring("abcabcbb")
    )
    println(
        lengthOfLongestSubstring("bbbbb")
    )
}