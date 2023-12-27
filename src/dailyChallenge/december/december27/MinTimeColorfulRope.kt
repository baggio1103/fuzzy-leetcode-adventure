package dailyChallenge.december.december27

import java.util.PriorityQueue

fun minCost(colors: String, neededTime: IntArray): Int {
    val queues = mutableListOf<PriorityQueue<Int>>()
    var index = 0
    while (index < colors.length) {
        val queue = PriorityQueue<Int>()
        for (j in index..colors.lastIndex) {
            if (colors[index] != colors[j]) {
                index = j
                queues.add(queue)
                break
            }
            queue.add(neededTime[j])
            if (j == colors.lastIndex) {
                index = colors.length
                queues.add(queue)
            }
        }
    }
    return queues.sumOf {
        var sum = 0
        while (it.size != 1) {
            sum += it.poll()
        }
        sum
    }
}

fun main() {
    println(
        minCost("aabbacdd", intArrayOf(1, 10, 21, 2, 3, 4, 5, 6))
    )
    println(
        minCost("aabaa", intArrayOf(1, 2, 3, 4, 1))
    )
    println(
        minCost("abaac", intArrayOf(1,2,3,4,5))
    )
}