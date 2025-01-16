package dailyChallenge.year2025.january.january16

fun main() {
    println(
        xorAllNums(
            arrayOne = intArrayOf(1, 2),
            arrayTwo = intArrayOf(3, 4),
        )
    )
}

fun xorAllNums(arrayOne: IntArray, arrayTwo: IntArray): Int {
    var i = 0
    arrayOne.forEach { numOne ->
        arrayTwo.forEach { numTwo ->
            i = i xor numOne xor numTwo
        }
    }
    return i
}