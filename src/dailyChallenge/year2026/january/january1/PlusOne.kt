package dailyChallenge.year2026.january.january1

fun main() {
    println(plusOne(intArrayOf(1, 2, 3)).contentToString())
    println(plusOne(intArrayOf(9)).contentToString())
    println(plusOne(intArrayOf(99)).contentToString())
    println(plusOne(intArrayOf(89)).contentToString())
    println(plusOne(intArrayOf(8, 9, 9, 9)).contentToString())
    println(plusOne(intArrayOf(9, 8, 9)).contentToString())
}

fun plusOne(digits: IntArray): IntArray {
    var addition = digits.last() + 1 == 10
    if (!addition) {
        digits[digits.lastIndex]++
        return digits
    }
    val result = mutableListOf<Int>()
    var index = digits.lastIndex
    while (index >= 0) {
        val digit = digits[index]
        if (digit + 1 == 10) {
            result.add(0, 0)
            addition = true
        } else {
            result.add(0, digit + 1)
            addition = false
            break
        }
        index--
    }
    if (addition) result.add(0, 1)
    for (i in index - 1 downTo 0) result.add(0, digits[i])
    return result.toIntArray()
}

//fun plusOne(digits: IntArray): IntArray {
//    val sum = digits.fold(BigInteger.ZERO) { acc, value ->
//        (BigInteger.TEN * acc) + value.toBigInteger()
//    } + BigInteger.ONE
//    var result = sum
//    val array = mutableListOf<Int>()
//    while (result != BigInteger.ZERO) {
//        val mod = result % BigInteger.TEN
//        array.add(0, mod.toInt())
//        result /= BigInteger.TEN
//    }
//    return array.toIntArray()
//}
