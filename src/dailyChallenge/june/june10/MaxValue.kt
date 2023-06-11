package dailyChallenge.june.june10

import kotlin.math.max

class MaxValue {

    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        return 1
    }
}

fun findX(arraySize: Int, index: Int, maxValue: Int) {
    val leftSideCount = index
    val rightSideCount = arraySize - 1 - index
    println("LeftSideCount: $leftSideCount rightSideCount: $rightSideCount")
    val leftSideSum = (1 + leftSideCount) / 2
    val rightSideSum = (1 + rightSideCount) / 2
    println("LeftSideSum: $leftSideSum, rightSideSum: $rightSideSum")
    println("Result: ${maxValue + leftSideSum + rightSideSum/ arraySize}")

}

fun main() {
    findX(
        4, 2, 100
    )
}