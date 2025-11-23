package dailyChallenge.year2025.november.november22

fun main() {
    println(longestSubsequence("1001010", 5))
//    println(longestSubsequence("00101001", 1))

}

fun longestSubsequence(string: String, k: Int): Int {
    var count = 0
    string.forEach { char -> if (char == '0') count++ }
    var power = 1L
    var value = 0L
    for (i in string.lastIndex downTo 0) {
        if (string[i] == '1' && power > k) break
        if (string[i] == '1' && value + power <= k) {
            value += power
            count++
        }
        power = power shl 1
        if (power > (1 shl 30)) break
    }
    return count
}

//fun longestSubsequence(string: String, k: Int): Int {
//    var value = 0L
//    var power = 1L
//    var count = 0
//    for (char in string) if (char == '0') count++
//    for (i in string.lastIndex downTo 0) {
//        if (string[i] == '1' && power > k) break
//        if (string[i] == '1' && value + power <= k) {
//            value += power
//            count++
//        }
//        power = power shl 1
//        if (power > (1L shl 30)) break
//    }
//    return count
//}
