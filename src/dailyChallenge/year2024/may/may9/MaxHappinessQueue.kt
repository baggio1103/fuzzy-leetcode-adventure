package dailyChallenge.year2024.may.may9

import java.util.PriorityQueue

fun maximumHappinessSumQueue(happinessArray: IntArray, k: Int): Long {
    val queue = PriorityQueue<Int>(happinessArray.size, reverseOrder()).apply {
        for (happiness in happinessArray) offer(happiness)
    }
    var happinessSum = 0L
    repeat(k) {
        val happiness = queue.poll() - it
        happinessSum += if (happiness < 0) 0 else happiness
    }
    return happinessSum
}

fun main() {
    println(
        maximumHappinessSumQueue(
            happinessArray = intArrayOf(1, 2, 3),
            2
        )
    )
    println(
        maximumHappinessSumQueue(
            intArrayOf(1, 1, 1, 1), 1
        ),
    )
    println(
        maximumHappinessSumQueue(
            intArrayOf(2, 3, 4, 5),
            1
        )
    )
}