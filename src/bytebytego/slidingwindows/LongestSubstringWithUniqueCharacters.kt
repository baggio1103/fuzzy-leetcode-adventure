package bytebytego.slidingwindows

fun main() {
    println(lengthOfLongestSubstring("abcba"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("bbbbb"))
}

fun lengthOfLongestSubstring(string: String): Int {
    var lenth = 0
    var l = 0
    var r = 0
    val chars = mutableSetOf<Char>()
    while (r < string.length) {
        val char = string[r]
        while (char in chars) {
            chars.remove(string[l])
            l++
        }
        chars.add(char)
        lenth = maxOf(lenth, r - l + 1)
        r++
    }
    return lenth
}
