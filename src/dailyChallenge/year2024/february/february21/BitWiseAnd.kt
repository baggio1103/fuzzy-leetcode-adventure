package dailyChallenge.year2024.february.february21

fun rangeBitwiseAnd(left: Int, right: Int): Int {
    var leftBit = left
    var rightBit = right
    var bits = 0
    while (leftBit != rightBit) {
        leftBit = leftBit shr 1
        rightBit = rightBit shr 1
        bits++
    }
    return rightBit shl bits
}

fun main() {
    val value = 212
    println(
        """ |Init : ${Integer.toBinaryString(value)}
            |Shr  - ${Integer.toBinaryString(value shr 1)}
            |Shl  - ${Integer.toBinaryString(value shl 1)}
            |""".trimMargin()
    )
    println(
        rangeBitwiseAnd(600000000, 2147483645)
    )
    println(
        rangeBitwiseAnd(
            5, 7
        )
    )
    println(
        rangeBitwiseAnd(1,
            2147483647)
    )
    println(
        rangeBitwiseAnd(600000000,
            2147483645)
    )
}