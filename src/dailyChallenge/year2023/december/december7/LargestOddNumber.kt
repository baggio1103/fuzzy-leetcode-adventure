package dailyChallenge.december.december7

fun largestOddNumber(number: String): String {
    var index = -1
    for (i in number.lastIndex downTo 0) {
        if (number[i].digitToInt() % 2 != 0) {
            index = i
            break
        }
    }
    if (index == -1) {
        return ""
    }
    return number.substring(IntRange(0, index))
}

fun main() {
    println(
        largestOddNumber("52")
    )
    println(
        largestOddNumber("4206")
    )
    println(
        largestOddNumber("35427")
    )
}
