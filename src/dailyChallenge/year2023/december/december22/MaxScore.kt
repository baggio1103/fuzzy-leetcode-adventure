package dailyChallenge.december.december22

fun maxScore(string: String): Int {
    var max = 0
    val ones = string.count { it == '1' }
    var currentZeros = 0
    var currentOnes = 0
    for (i in 0 until string.lastIndex) {
        val char = string[i]
        val sum = if (char == '0') {
            currentZeros++
            currentZeros + (ones - currentOnes)
        } else {
            currentOnes++
            currentZeros + (ones - currentOnes)
        }
        if (sum > max) {
            max = sum
        }
    }
    return max
}

fun main() {
    println(
        maxScore("011101")
    )
    println(
        maxScore("00111")
    )
    println(
        maxScore("1111")
    )
}