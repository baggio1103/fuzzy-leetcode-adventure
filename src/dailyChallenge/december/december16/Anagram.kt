package dailyChallenge.december.december16

fun isAnagram(s: String, t: String): Boolean {
    return t.groupingBy { it }.eachCount() == s.groupingBy { it }.eachCount()
}

fun main() {
    println(
        isAnagram("anagram", "nagaram")
    )
    println(
        isAnagram("rat", "car")
    )
}