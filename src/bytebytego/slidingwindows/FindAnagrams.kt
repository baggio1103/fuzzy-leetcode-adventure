package bytebytego.slidingwindows

fun main() {
    println(findAnagrams("caabab", "aba"))
}

fun findAnagrams(string: String, t: String): List<Int> {
    if (t.length > string.length) return emptyList()
    val expectedFreq = IntArray(26)
    for (ch in t)
        expectedFreq[ch - 'a']++
    val windowFreq = IntArray(26)
    var l = 0
    var r = 0
    val result = mutableListOf<Int>()
    while (r < string.length) {
        windowFreq[string[r] - 'a']++
        if (r - l + 1 == t.length) {
            if (expectedFreq.contentEquals(windowFreq))
                result.add(l)
            windowFreq[string[l] - 'a']--
            l++
        }
        r++
    }
    return result
}
