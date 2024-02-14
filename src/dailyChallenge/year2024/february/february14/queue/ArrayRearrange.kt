package dailyChallenge.year2024.february.february14.queue

import java.util.ArrayDeque


fun rearrangeArray(array: IntArray): IntArray {
    val positiveQueue = ArrayDeque<Int>()
    val negativeQueue = ArrayDeque<Int>()
    array.forEach {
        if (it < 1) {
            negativeQueue.add(it)
        } else positiveQueue.offer(it)
    }
    return IntArray(array.size) { index ->
        if (index % 2 == 0) positiveQueue.poll() else negativeQueue.poll()
    }
}

fun main() {
    val array = intArrayOf(3, 1, -2, -5, 2, -4)
    println(
        rearrangeArray(
            array
        ).asList()
    )
}