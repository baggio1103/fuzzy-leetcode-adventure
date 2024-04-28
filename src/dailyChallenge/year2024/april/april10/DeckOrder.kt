package dailyChallenge.year2024.april.april10

import java.util.ArrayDeque

fun deckRevealedIncreasing(deck: IntArray): IntArray {
    val result = IntArray(deck.size)
    deck.sort()
    val queue = ArrayDeque<Int>()
    deck.indices.forEach { queue.offer(it) }
    for (i in deck.indices) {
        result[queue.poll()] = deck[i]
        if (queue.isNotEmpty()) queue.offer(queue.poll())
    }
    return result
}

fun main() {
    println(
        deckRevealedIncreasing(
            intArrayOf(17, 13, 11, 2, 3, 5, 7)
        )
    )
}
