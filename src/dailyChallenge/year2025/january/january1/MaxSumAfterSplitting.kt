package dailyChallenge.year2025.january.january1

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
    println(
        maxScore("00")
    )
    println(
        maxScore("01001")
    )
}

fun maxScore(s: String): Int {
    var leftSide = 0
    var rightSide = 0
    if (s[0] == '0') {
        leftSide++
    }
    for (i in 1..s.lastIndex) {
        if (s[i] == '1') {
            rightSide++
        }
    }
    var max = leftSide + rightSide
    for (i in 1 until s.lastIndex) {
        if (s[i] == '0') {
            leftSide++
        }
        if (s[i] == '1') {
            rightSide--
        }
        max = maxOf(max, leftSide + rightSide)
    }
    return max
}