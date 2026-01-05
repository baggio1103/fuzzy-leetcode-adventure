package dailyChallenge.year2026.january.january5

import kotlin.math.absoluteValue

fun main() {
//    println(
//        maxMatrixSum(
//            matrix = arrayOf(
//                intArrayOf(1, 2, 3),
//                intArrayOf(-1, -2, -3),
//                intArrayOf(1, 2, 3),
//            )
//        )
//    )
    println(
        maxMatrixSum(
            matrix = arrayOf(
                intArrayOf(-1, 0, -1),
                intArrayOf(-2, 1, 3),
                intArrayOf(3, 2, 2),
            )
        )
    )
}

fun maxMatrixSum(matrix: Array<IntArray>): Long {
    var sum = 0L
    var min = matrix[0][0].absoluteValue
    var negCount = 0
    for (row in matrix) {
        for (value in row) {
            min = minOf(value.absoluteValue, min)
            if (value < 0) negCount++
            sum += value.absoluteValue
        }
    }
    if (negCount % 2 != 0) sum -= 2 * min
    return sum
}
