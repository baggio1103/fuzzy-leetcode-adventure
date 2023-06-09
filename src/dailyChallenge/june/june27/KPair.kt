package dailyChallenge.june.june27

import java.util.PriorityQueue
import kotlin.math.min

class KPair {

    fun kSmallestPairs(arrayOne: IntArray, arrayTwo: IntArray, k: Int): List<List<Int>> {
        return if (arrayOne.size >= k && arrayTwo.size >= k) {
            caseOne(arrayOne, arrayTwo, k)
        } else {
            caseTwo(arrayOne, arrayTwo, k)
        }
    }

    fun caseOne(arrayOne: IntArray, arrayTwo: IntArray, k: Int): List<List<Int>> {
        val queueOne = PriorityQueue<Int>()
        val queueTwo = PriorityQueue<Int>()
        arrayOne.forEach {
            queueOne.add(it)
        }
        arrayTwo.forEach {
            queueTwo.add(it)
        }
        val list = mutableListOf<List<Int>>()
        for (i in 1 .. min(k, arrayOne.size * arrayOne.size)) {
            val valueOne: Int? = queueOne.peek()
            val valueTwo: Int? = queueTwo.peek()
            if (valueOne == null || valueTwo == null) {
                continue
            }
            val element = if (valueOne < valueTwo) {
                queueTwo.poll()
                listOf(valueOne, valueTwo)
            } else {
                queueOne.poll()
                listOf(valueTwo, valueOne)
            }
            list.add(element)
        }
        return list
    }

    fun caseTwo(arrayOne: IntArray, arrayTwo: IntArray, k: Int): List<List<Int>> {
        val priorityQueue = PriorityQueue<List<Int>>(Comparator
        { a, b ->
            if (a.sum() > b.sum()
            ) {
                1
            } else if (a.sum() < b.sum()) {
                -1
            } else 0
        })
        arrayOne.forEach { aValue ->
            arrayTwo.forEach { bValue ->
                priorityQueue.add(listOf(aValue, bValue))
            }
        }
        var i = 0
        val list = mutableListOf<List<Int>>()
        while (i < k && priorityQueue.isNotEmpty()) {
            list.add(priorityQueue.poll())
            i++
        }
        return list
    }

}

fun main() {
    val solution = KPair()
    println("-=-=-=-=-=-=-=-=-=-=")
    println(
        solution.kSmallestPairs(intArrayOf(1, 7, 11), intArrayOf(2, 4, 6), 3)
    )
    println("-=-=-=-=-=-=-=-=-=-=")
    println(
        solution.kSmallestPairs(intArrayOf(1, 1, 2), intArrayOf(1, 2, 3), 2)
    )
    println("-=-=-=-=-=-=-=-=-=-=")
    println(
        solution.kSmallestPairs(intArrayOf(1, 2), intArrayOf(3), 2)
    )

    println("-=-=-=-=-=-=-=-=-=-=")
    println(
        solution.kSmallestPairs(intArrayOf(1, 1, 2), intArrayOf(1, 2, 3), 10)
    )
    println("-=-=-=-=-=-=-=-=-=-=")
    println(
        solution.caseTwo(
            intArrayOf(1, 1, 2), intArrayOf(1, 2, 3), 10
        )
    )

    println(
        solution.kSmallestPairs(
            intArrayOf(1,2,4,5,6), intArrayOf(3,5,7,9), 3
        )
    )

}