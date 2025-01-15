package dailyChallenge.year2025.january.january15

fun main() {
    println(minimizeXor(3, 5))
}

fun minimizeXor(numOne: Int, numTwo: Int): Int {
    fun isSet(x: Int, bit: Int): Boolean {
        return (x and (1 shl bit)) != 0
    }

    fun setBit(x: Int, bit: Int): Int {
        return x or (1 shl bit)
    }

    var result = 0
    val targetSetBitsCount = Integer.bitCount(numTwo)
    var setBitsCount = 0
    var currentBit = 31
    while (setBitsCount < targetSetBitsCount) {
        if (isSet(numOne, currentBit) || (targetSetBitsCount - setBitsCount > currentBit)) {
            result = setBit(result, currentBit)
            setBitsCount++
        }
        currentBit--
    }
    return result
}