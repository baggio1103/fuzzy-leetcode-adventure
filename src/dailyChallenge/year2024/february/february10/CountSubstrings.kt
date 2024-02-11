package dailyChallenge.year2024.february.february10

fun countSubstrings(string: String): Int {
    var counter = 0
    for (i in string.indices) {
        for (j in 0 .. string.lastIndex - i) {
            val substring = string.substring(j..j + i)
            if (isPalindrome(substring)) {
                counter++
            }
        }
    }
    return counter
}

fun isPalindrome(substring: String): Boolean {
    var i = 0
    var j = substring.lastIndex
    while (j > i) {
        if (substring[i] != substring[j]) {
            return false
        }
        i++
        j--
    }
    return true
}

fun main() {
    println(
        countSubstrings(
            "aaa"
        )
    )
}