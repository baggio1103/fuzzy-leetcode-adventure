package dailyChallenge.june.june26

import java.util.*

fun estimate(costs: IntArray, k: Int, candidates: Int): Int {
    val array = if (2 * candidates >= costs.size || 2 * candidates + k - 1 >= costs.size) {
        costs
    } else {
        val leftPriorityQueue = PriorityQueue<Int>()
        val rightPriorityQueue = PriorityQueue<Int>()
        for (i in 0 until candidates) {
            leftPriorityQueue.add(costs[i])
        }
        for (i in costs.size - candidates until costs.size) {
            rightPriorityQueue.add(costs[i])
        }

        val list = mutableListOf<Int>()
        var leftBorder = candidates
        var rightBorder = costs.size - candidates - 1
        for (i in 1 .. k) {
            val leftValue = leftPriorityQueue.peek()
            val rightValue = rightPriorityQueue.peek()
            if (leftValue <= rightValue) {
                list.add(leftPriorityQueue.poll())
                leftPriorityQueue.add(costs[leftBorder])
                leftBorder++
            } else {
                list.add(rightPriorityQueue.poll())
                rightPriorityQueue.add(costs[rightBorder])
                rightBorder--
            }
        }
        list.toIntArray()
    }
    array.sort()
    var cost = 0
    for (i in 0 until k) {
        cost += array[i]
    }
    return cost
}

fun main() {
    estimate(intArrayOf(
        60,66,17,17,35,46,77,7,15,38,35,61,90,34,29,68,35,9,18,82,78,40,8,71,2,59,70,12,88,73,12,55,88,59,71,49,47,46,65,37,24,75,81,54,39,70)
    , 37, 40).let {
        println(it)
    }

    println(
        estimate(intArrayOf(17,12,10,2,7,2,11,20,8), 3, 4)
    )

    println(estimate(intArrayOf(1, 2, 4, 1), 3, 3))

    println(
        estimate(intArrayOf(
            31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58
        ), 11, 2)
    )
    println(
        intArrayOf(17, 25, 31, 33, 58, 9, 27, 59, 18, 72, 74).sum()
    )
}