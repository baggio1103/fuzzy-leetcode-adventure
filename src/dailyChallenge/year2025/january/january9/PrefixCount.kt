package dailyChallenge.year2025.january.january9

fun main() {
    println(
        prefixCount(
            words = arrayOf("pay", "attention", "practice", "attend"), "at"
        )
    )
    println(
        prefixCount(
            words = arrayOf("leetcode","win","loops","success"), "code"
        )
    )
}

fun prefixCount(words: Array<String>, pref: String): Int {
    var count = 0
    var skip = false
    for (word in words) {
        if (pref.length > word.length) continue
        for ((index, char) in pref.withIndex()) {
            if (char != word[index]) {
                skip = true
                continue
            }
        }
        if (skip) {
            skip = false
            continue
        }
        count++
    }
    return count
}