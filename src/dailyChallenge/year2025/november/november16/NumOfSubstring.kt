package dailyChallenge.year2025.november.november16

fun main() {
    println(numSub("0110111"))
    println(numSub("101"))
    println(numSub("111111"))
}

fun numSub(string: String): Int {
    val mod = 1_000_000_007
    var result = 0
    var count = 0
    string.forEach { char ->
        if (char == '1') {
            count++
            result = (result + count) % mod
        } else {
            count = 0
        }
    }
    return result
}
