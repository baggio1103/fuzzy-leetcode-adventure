package dailyChallenge.year2024.april.april2

fun isIsomorphic(s: String, t: String): Boolean {
    val sMap = mutableMapOf<Char, Char>()
    val tMap = mutableMapOf<Char, Char>()
    for (i in s.indices) {
        if (sMap[s[i]] == null && tMap[t[i]] == null) {
            sMap[s[i]] = t[i]
            tMap[t[i]] = s[i]
            continue
        }
        if (sMap[s[i]] != t[i] && tMap[t[i]] != s[i]) {
            return false
        }
    }
    return true
}


fun main() {
    println(
        isIsomorphic("foo", "bar")
    )
    println(
        isIsomorphic("paper", "title")
    )
    println(
        isIsomorphic("title", "paper")
    )
    println(
        isIsomorphic("badc", "baba")
    )
    println(
        isIsomorphic("egg", "add")
    )
    println(
        isIsomorphic("bbbaaaba", "aaabbbba")
    )
}