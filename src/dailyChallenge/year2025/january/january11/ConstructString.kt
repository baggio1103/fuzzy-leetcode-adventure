package dailyChallenge.year2025.january.january11


fun main() {
    println(
        canConstruct("annabelle", 2)
    )
    println(canConstruct("messi", 3))
    println(canConstruct("leetcode", 3))
}

// Using Map
//fun canConstruct(string: String, k: Int): Boolean {
//    if (string.length == k) return true
//    if (string.length < k) return false
//
//    val charCount = string.groupingBy { it }.eachCount()
//    val odds = charCount.filter { (_, count) -> count % 2 == 1 }.count()
//    return odds <= k
//}


// BIT Manipulation
fun canConstruct(string: String, k: Int): Boolean {
    if (string.length == k) return true
    if (string.length < k) return false
    val oddCount = string.foldRight(0) { char, acc ->
        acc xor (1 shl (char - 'a'))
    }
    return Integer.bitCount(oddCount) <= k
}