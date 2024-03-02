package dailyChallenge.year2024.march.march2

fun sortedSquares(array: IntArray): IntArray {
    var left = array.indexOfLast { it < 0 }
    var right = array.indexOfFirst { it >= 0 }
    val result = IntArray(array.size) { 0 }
    println("Left: $left, right: $right")
    var index = 0
    while (true) {
        if (left < 0) {
            for (i in right until array.size) {
                result[index] = array[i] * array[i]
                index++
            }
            return result
        }
        if (right >= array.size || right == -1) {
            for (i in left downTo 0) {
                result[index] = array[i] * array[i]
                index++
            }
            return result
        }
        val leftValue = array[left] * array[left]
        val rightValue = array[right] * array[right]
        result[index] = if (leftValue > rightValue) {
            right++
            rightValue
        } else {
            left--
            leftValue
        }
        index++
    }
}


//-4,-1,0,3,10
fun main() {
    println(
        sortedSquares(
            intArrayOf(-4, -1, 0, 3, 10)
        ).asList()
    )
    println(
        sortedSquares(
            intArrayOf(-7, -3, 2, 3, 11)
        ).asList()
    )
    println(
        sortedSquares(intArrayOf(-1))
            .asList()
    )
    println(
        sortedSquares(
            intArrayOf(-5, -3, -2, -1)
        ).asList()
    )
}