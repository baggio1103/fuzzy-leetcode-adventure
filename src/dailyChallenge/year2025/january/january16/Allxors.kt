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
    val result = IntArray(arrayOne.size * arrayTwo.size)
    var i = 0
    arrayOne.forEach { numOne ->
        arrayTwo.forEach { numTwo ->
            result[i] = numOne xor numTwo
            i++
        }
    }
    return result.fold(0) {
        a, b -> a xor b
    }
}