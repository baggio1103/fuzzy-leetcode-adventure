package dailyChallenge.november.november23

fun checkArithmeticSubArrays(array: IntArray, left: IntArray, right: IntArray): List<Boolean> {
    val subArraySize = left.size
    val answers = mutableListOf<Boolean>()
    for (i in 0 until subArraySize) {
        val subArray = array.sliceArray(IntRange(left[i], right[i]))
        subArray.sort()
        answers.add(isArithmeticSequence(subArray))
    }
    return answers
}

fun isArithmeticSequence(array: IntArray): Boolean {
    val diff = array[1] - array[0]
    for (i in 1 until array.size - 1) {
        if (array[i + 1] - array[i] != diff) {
            return false
        }
    }
    return true
}

fun main() {
    println(
        checkArithmeticSubArrays(intArrayOf(4, 6, 5, 9, 3, 7), intArrayOf(0, 0, 2), intArrayOf(2, 3, 5))
    )
    println(isArithmeticSequence(intArrayOf(5, 9, 3, 7)))
    println(isArithmeticSequence(intArrayOf(4, 6, 5)))
    println(
        checkArithmeticSubArrays(
            intArrayOf(-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10),
            intArrayOf(0, 1, 6, 4, 8, 7),
            intArrayOf(4, 4, 9, 7, 9, 10)
        )
    )
}