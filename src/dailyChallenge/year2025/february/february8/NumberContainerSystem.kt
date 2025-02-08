package dailyChallenge.year2025.february.february8

import java.util.PriorityQueue

fun main() {
    val numberContainers = NumberContainers()
//["NumberContainers","find","change","change","change","change","find","change","find"]
//[[],[10],[2,10],[1,10],[3,10],[5,10],[10],[1,20],[10]]

    // 10 -> 1, 2, 3, 5
    // 10 -> true (1)
    // (1, 20) =>
    // 10 -> 1, 2, 3, 5
    // 20 -> 1
    println(numberContainers.find(10))
    numberContainers.change(2, 10)
    numberContainers.change(1, 10)
    numberContainers.change(3, 10)
    numberContainers.change(5, 10)
    println(numberContainers.find(10))
    numberContainers.change(1, 20)
    println(numberContainers.find(10))
}

class NumberContainers {

    private val numberToIndex = mutableMapOf<Int, PriorityQueue<Int>>()

    private val indexToNumber = mutableMapOf<Int, Int>()

    fun change(index: Int, number: Int) {
        indexToNumber[index] = number
        numberToIndex.getOrPut(number) { PriorityQueue<Int>() }.offer(index)
    }

    fun find(number: Int): Int {
        val queue = numberToIndex[number] ?: return -1
        while (queue.isNotEmpty()) {
            val index = queue.peek()
            if (indexToNumber[index] == number) return index
            queue.poll()
        }
        return -1
    }

}

