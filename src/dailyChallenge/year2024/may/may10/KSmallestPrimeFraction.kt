package dailyChallenge.year2024.may.may10

import java.util.PriorityQueue

fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
    val queue = PriorityQueue<Triple<Double, Int, Int>>(compareBy { it.first })
    for (i in 0 until arr.lastIndex) {
        queue.offer(Triple(arr[i].toDouble() / arr.last(), i, arr.lastIndex))
    }
    repeat(k - 1) {
        val (_, numerator, denominator) = queue.poll()
        queue.offer(Triple(arr[numerator].toDouble() / arr[denominator - 1], numerator, denominator - 1))
    }
    val (_, numerator, denominator) = queue.poll()
    return intArrayOf(arr[numerator], arr[denominator])
}

fun main() {
    println(
        kthSmallestPrimeFraction(
            intArrayOf(1, 2, 3, 5),
            3
        ).asList()
    )
}