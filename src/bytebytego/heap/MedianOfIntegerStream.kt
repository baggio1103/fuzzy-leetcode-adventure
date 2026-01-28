package bytebytego.heap

import java.util.PriorityQueue

fun main() {
    val finder = MedianFinder()
    finder.addNum(1)
    finder.addNum(2)
    require(finder.findMedian() == 1.5)
    finder.addNum(3)
    require(finder.findMedian() == 2.0)
}

class MedianFinder {

    private val minQueue = PriorityQueue<Int>()
    private val maxQueue = PriorityQueue<Int>(compareByDescending { it })

    fun addNum(num: Int) {
        if (maxQueue.isEmpty() || num <= maxQueue.peek()) maxQueue.offer(num) else minQueue.offer(num)
        when {
            maxQueue.size > minQueue.size + 1 -> minQueue.offer(maxQueue.poll())
            minQueue.size > maxQueue.size -> maxQueue.offer(minQueue.poll())
        }
    }

    fun findMedian(): Double = when {
        maxQueue.size == minQueue.size -> (maxQueue.peek().toDouble() + minQueue.peek()) / 2
        else -> maxQueue.peek().toDouble()
    }

}
