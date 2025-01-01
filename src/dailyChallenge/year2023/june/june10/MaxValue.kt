package dailyChallenge.june.june10

class MaxValue {

    fun maxValue(arraySize: Int, index: Int, maxSum: Int): Int {
        val rightSideCount = arraySize - index - 1
        val leftSideSum = (1 + index) * index / 2
        val rightSideSum = (1 + rightSideCount) * rightSideCount / 2
        val sum = maxSum + leftSideSum + rightSideSum
        val result = sum / arraySize
        val array = IntArray(arraySize)
        for (i in 0 ..  index) {
            array[i] = result - index + i
        }
        for (i in index + 1 until arraySize) {
            array[i] = result - (i - index)
        }
        println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
        println(array.asList())
        println(array.sum())
        return array[index]
    }

}

fun findX(arraySize: Int, index: Int, maxValue: Int) {
    val rightSideCount = arraySize - index - 1
    println("LeftSideCount: $index rightSideCount: $rightSideCount")
    val leftSideSum = (1 + index) * index / 2
    val rightSideSum = (1 + rightSideCount) * rightSideCount / 2

    println("LeftSideSum: $leftSideSum, rightSideSum: $rightSideSum")
    println("Sum: ${maxValue + leftSideSum + rightSideSum}")
    println("ArraySize: $arraySize ${maxValue + leftSideSum + rightSideSum}")
    val sum = maxValue + leftSideSum + rightSideSum
    val result = sum / arraySize
    val array = IntArray(arraySize)
    for (i in 0 ..  index) {
        array[i] = result - index + i
    }
    for (i in index + 1 until arraySize) {
        array[i] = result - (i - index)
    }
    println(array.sum())
    println(array.asList())
}

fun main() {
    findX(
        4, 2, 100
    )
    findX(
        7, 4, 36
    )
    findX(6, 1, 10)
//    println(intArrayOf(3, 4, 5, 6, 7, 6, 5).sum())

    val maxValue = MaxValue()
    println(
        maxValue.maxValue(8, 7, 14)
    )

}