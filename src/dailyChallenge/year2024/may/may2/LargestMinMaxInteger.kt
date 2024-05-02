package dailyChallenge.year2024.may.may2

import java.util.PriorityQueue

fun findMaxK(nums: IntArray): Int {
    val set = hashSetOf<Int>()
    val queue = PriorityQueue<Int>(Comparator.reverseOrder()).apply {
        for (num in nums) {
            add(num)
            set.add(num)
        }
    }
    while (queue.isNotEmpty()) {
        val poll = queue.poll()
        if (set.contains(-poll)) return poll
    }
    return -1
}

fun main() {
    println(
        findMaxK(
            intArrayOf(-1, 2, -3, 3)
        )
    )
    println(
        findMaxK(
            intArrayOf(-1, 10, 6, 7, -7, 1)
        )
    )

}