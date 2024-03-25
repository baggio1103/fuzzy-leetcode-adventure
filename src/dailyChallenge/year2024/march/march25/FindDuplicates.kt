package dailyChallenge.year2024.march.march25

import kotlin.math.absoluteValue

fun findDuplicates(array: IntArray): List<Int> {
    val list = mutableListOf<Int>()
    for (i in array.indices) {
        val index = array[i].absoluteValue - 1
        array[index] = -array[index]
        if (array[index] > 0) {
            list.add(index + 1)
        }
    }
    return list
}

fun main() {
    println(
        findDuplicates(
            intArrayOf(3, 1, 3, 1, 5, 6)
        )
    )
    println(
        findDuplicates(
            intArrayOf(10, 2, 5, 10, 9, 1, 1, 4, 3, 7)
        )
    )
}