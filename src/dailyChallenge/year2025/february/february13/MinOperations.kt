package dailyChallenge.year2025.february.february13

import java.util.*

fun main() {
    println(
        minOperations(intArrayOf(2, 11, 10, 1, 3), 10)
    )
    println(
        minOperations(
            intArrayOf(1000000000, 999999999, 1000000000, 999999999, 1000000000, 999999999),
            1000000000
        )
    )
}

fun minOperations(array: IntArray, k: Int): Int {
    var count = 0
    val queue = PriorityQueue<Long>().apply {
        array.forEach { add(it.toLong()) }
    }
    while (queue.size >= 2 && queue.peek() < k) {
        val x = queue.poll()
        val y = queue.poll()
        queue.offer(2 * minOf(x, y) + maxOf(x, y))
        count++
    }
    return count
}