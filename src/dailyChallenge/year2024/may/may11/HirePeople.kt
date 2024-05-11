package dailyChallenge.year2024.may.may11

import java.util.PriorityQueue

fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
    val array = Array(quality.size) {
        Pair(wage[it].toDouble() / quality[it], quality[it])
    }.apply { sortBy { it.first } }
    var minWage = Double.MAX_VALUE
    val queue = PriorityQueue<Int>(reverseOrder())
    var qualitySum = 0
    for ((wageRatio, qualityUnit) in array) {
        qualitySum += qualityUnit
        queue.offer(qualityUnit)
        if (queue.size > k) {
            qualitySum -= queue.poll()
        }
        if (queue.size == k) {
            minWage = minOf(minWage, qualitySum * wageRatio)
        }
    }
    return minWage
}

fun main() {
    println(
        mincostToHireWorkers(
            quality = intArrayOf(10, 20, 5),
            wage = intArrayOf(70, 50, 30),
            2
        )
    )
}