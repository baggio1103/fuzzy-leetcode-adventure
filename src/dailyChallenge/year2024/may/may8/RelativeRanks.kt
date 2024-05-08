package dailyChallenge.year2024.may.may8

import java.util.Comparator
import java.util.PriorityQueue

fun findRelativeRanks(score: IntArray): Array<String> {
    val queue = PriorityQueue<Int>(Comparator.reverseOrder()).apply {
        for (sc in score) offer(sc)
    }
    val map = mutableMapOf<Int, Int>()
    repeat(queue.size) {
        map[queue.poll()] = it
    }
    return Array(score.size) {
        val rank = map[score[it]] ?: 0
        when (rank) {
            0 -> "Gold Medal"
            1 -> "Silver Medal"
            2 -> "Bronze Medal"
            else -> "${rank + 1}"
        }
    }
}

fun main() {
    println(
        findRelativeRanks(
            intArrayOf(10, 3, 8, 9, 4)
        ).asList()
    )
}