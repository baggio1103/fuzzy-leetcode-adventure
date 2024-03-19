package dailyChallenge.year2024.march.march19

import java.util.PriorityQueue
import java.util.ArrayDeque

fun leastInterval(tasks: CharArray, n: Int): Int {
    val charMap = mutableMapOf<Char, Int>()
    tasks.forEach {
        val count = charMap[it] ?: 0
        charMap[it] = count + 1
    }
    val heap = PriorityQueue<Int>(Comparator.reverseOrder()).apply {
        addAll(charMap.values)
    }
    var time = 0
    // [count, time]
    val queue = ArrayDeque<Pair<Int, Int>>()
    while (heap.isNotEmpty() || queue.isNotEmpty()) {
        time++
        if (heap.isNotEmpty()) {
            val count = heap.poll() - 1
            if (count != 0) {
                queue.offer(Pair(count, time + n))
            }
        }
        if (queue.isNotEmpty() && queue.peek().second == time) {
            heap.offer(queue.poll().first)
        }
    }
    return time
}

fun main() {
    println(
        leastInterval(
            charArrayOf('A', 'A', 'A', 'B', 'B', 'B'),
            2
        )
    )
    println(
        leastInterval(
            charArrayOf('A', 'B', 'A'),
            2
        )
    )
}