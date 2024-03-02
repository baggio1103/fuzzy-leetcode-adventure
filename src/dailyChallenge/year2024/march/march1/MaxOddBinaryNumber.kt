package dailyChallenge.year2024.march.march1

fun maximumOddBinaryNumber(string: String): String {
    val ones = string.count { it == '1' } - 1
    val charArray = CharArray(string.length) { '0' }
    charArray[string.lastIndex] = '1'
    repeat(ones) {
        charArray[it] = '1'
    }
    return charArray.joinToString(separator = "") { "$it" }
}

fun main() {
    println(
        maximumOddBinaryNumber("010")
    )
    println(
        maximumOddBinaryNumber("0101")
    )
    println(
        maximumOddBinaryNumber("0111")
    )
}