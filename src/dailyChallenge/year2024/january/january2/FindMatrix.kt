package dailyChallenge.year2024.january.january2

import java.util.Comparator
import java.util.PriorityQueue

fun findMatrix(array: IntArray): List<List<Int>> {
    val map = mutableMapOf<Int, Int>()
    array.forEach {
        val value = map.getOrDefault(it, 0)
        map[it] = value + 1
    }
    val queue = PriorityQueue(
        Comparator.comparingInt<Pair<Int, Int>> { it.second }.reversed()
    ).apply {
        map.forEach { (key, value) ->
            add(Pair(key, value))
        }
    }
    val (_, largestCount) = queue.peek()
    val list = List(largestCount) { _ ->
        mutableListOf<Int>()
    }
    repeat(queue.size) {
        val (value, count) = queue.poll()
        repeat(count) {
            list[it].add(value)
        }
    }
    return list
}

fun main() {
    println(
        findMatrix(intArrayOf(1, 3, 5, 5, 5, 5, 5, 4, 1, 2, 3, 1))
    )
    println(
        findMatrix(intArrayOf(1, 3, 4, 1, 2, 3, 1))
    )
}