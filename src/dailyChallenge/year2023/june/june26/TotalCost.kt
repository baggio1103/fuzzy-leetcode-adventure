package dailyChallenge.june.june26

import java.util.*

class TotalCost {

    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
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
        var cost: Long = 0
        for (i in 0 until k) {
            cost += array[i]
        }
        return cost
    }

}

fun main() {
    val totalCost = TotalCost()
    val array = intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8)
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        totalCost.totalCost(array, 3, 4)
    )

    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        totalCost.totalCost(intArrayOf(1,2,4,1), 3, 3)
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        totalCost.totalCost(
            intArrayOf(3, 7, 1, 5, 2),
            3, 3
        )
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    println(
        totalCost.totalCost(
            intArrayOf(18,64,12,21,21,78,36,58,88,58,99,26,92,91,53,10,24,25,20,92,73,63,51,65,87,6,17,32,14,42,46,65,43,9,75),
            13, 23)
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=")

}