package dailyChallenge.year2024.march.march26

import kotlin.math.absoluteValue

fun firstMissingPositive(array: IntArray): Int {
    var containsOne = false
    val n = array.size
    for (i in array.indices) {
        if (array[i] == 1) {
            containsOne = true
            continue
        }
        if (array[i] <= 0 || array[i] > n) {
            array[i] = 1
        }
    }
    if (!containsOne) return 1
    for (i in 0 until  n) {
        val value = array[i].absoluteValue
        if (value == n) {
            array[0] = - array[0].absoluteValue
        } else
            array[value] = - array[value].absoluteValue
    }
    for (i in 1 until n) {
        if (array[i] > 0) return i
    }
    if (array[0] > 0) return n
    return n + 1
}


fun main() {
    println(
        firstMissingPositive(
            intArrayOf(0, 1, 2)
        )
    )
}