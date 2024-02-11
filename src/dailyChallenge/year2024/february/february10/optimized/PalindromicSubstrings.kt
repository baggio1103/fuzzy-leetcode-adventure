package dailyChallenge.year2024.february.february10.optimized

fun countSubstrings(string: String): Int {
    var counter = 0
    for (i in string.indices) {
        counter += check(string, i, i)
    }
    for (i in 0 until string.lastIndex) {
        counter += check(string, i, i + 1)
    }
    return counter
}

fun check(string: String, leftIndex: Int, rightIndex: Int): Int {
    var count = 0
    var left = leftIndex
    var right = rightIndex
    while (left >= 0 && right < string.length) {
        if (string[left] != string[right]) {
            break
        }
        count++
        left--
        right++
    }
    return count
}

fun main() {
    println(
        countSubstrings(
            "abaca"
        )
    )
    println(
        countSubstrings("aaa")
    )
    println(
        countSubstrings("abc")
    )
}