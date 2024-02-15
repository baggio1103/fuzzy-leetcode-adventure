package dailyChallenge.year2024.february.february15

import java.util.Comparator
import java.util.PriorityQueue
import kotlin.random.Random
import kotlin.random.nextInt

fun largestPerimeter(array: IntArray): Long {
    var sum = array.sumOf { it.toLong() }
    val queue = PriorityQueue<Int>(Comparator.reverseOrder()).apply {
        array.forEach {
            offer(it)
        }
    }
    while (queue.size > 2) {
        val poll = queue.poll()
        if (poll < sum - poll) {
            return sum
        }
        sum -= poll
    }
    return -1
}

fun main() {
    println(
        largestPerimeter(
            intArrayOf(1, 12, 1, 2, 5, 50, 3)
        )
    )
    println(
        largestPerimeter(
            intArrayOf(5, 5, 5)
        )
    )
    println(
        largestPerimeter(
            intArrayOf(5, 5, 50)
        )
    )
    println(
        largestPerimeter(
            IntArray(10_000) {
                Random.nextInt(1..1_000_000_00)
            }
        )
    )
}