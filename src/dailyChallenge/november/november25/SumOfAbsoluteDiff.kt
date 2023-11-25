package dailyChallenge.november.november25

fun getSumAbsoluteDifferences(array: IntArray): IntArray {
    var acc = 0
    val sumArray = array.map { value ->
        acc += value
        acc
    }
    val size = array.size
    val resultingArray = IntArray(size)
    array.forEachIndexed { index, value ->
        val sum = when (index) {
            0 -> sumArray.last() - (value * (size))
            size - 1 -> array.last() * size - sumArray.last()
            else -> {
                val leftSide = (value * (index + 1)) - sumArray[index]
                val rightSide = sumArray.last() - sumArray[index] - ((size - index - 1) * value)
                leftSide + rightSide
            }
        }
        resultingArray[index] = sum
    }
    return resultingArray
}

fun main() {
    println(
        getSumAbsoluteDifferences(intArrayOf(2, 3, 5)).asList()
    )
    println(
        getSumAbsoluteDifferences(intArrayOf(1, 4, 6, 8,  10)).asList()
    )
}