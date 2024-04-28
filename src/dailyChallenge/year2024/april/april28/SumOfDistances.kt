package dailyChallenge.year2024.april.april28

import java.util.ArrayDeque

fun sumOfDistancesInTree(n: Int, edges: Array<IntArray>): IntArray {
    val adjMap = mutableMapOf<Int, MutableList<Int>>()
    for ((from, to) in edges) {
        adjMap[from]?.add(to) ?: run { adjMap[from] = mutableListOf(to) }
        adjMap[to]?.add(from) ?: run { adjMap[to] = mutableListOf(from) }
    }
    val result = IntArray(1)
    for (i in 1 until 2) {
        var sum = 0
        val queue = ArrayDeque<Int>()
        val visitedNodes = hashSetOf<String>()
        queue.add(i)
        var depth = 0
        var nodeCount = 1
        while (queue.isNotEmpty()) {
            var count = 0
            depth++
            repeat(nodeCount) {
                val from = queue.poll()
                val list = adjMap[from]?.filter {
                    !visitedNodes.contains("$from-$it") && !visitedNodes.contains("$it-$from")
                } ?: return@repeat

                sum += (depth * list.size)
                list.forEach { to ->
                    val (keyOne, keyTwo) = Pair("$from-$to", "$to-$from")
                    if (!visitedNodes.contains(keyOne) && !visitedNodes.contains(keyTwo)) {
                        queue.offer(to)
                        visitedNodes.add(keyOne)
                        visitedNodes.add(keyTwo)
                    }
                }
                count += list.size
            }
            nodeCount = count
        }
        result[0] = sum
    }
    println("Result: ${result.asList()}")
    return result
}

fun main() {
    println(
        sumOfDistancesInTree(
            5,
            edges = arrayOf(
                intArrayOf(2, 0),
                intArrayOf(4, 2),
                intArrayOf(3, 1),
                intArrayOf(1, 0),
            )
        )
    )
//    println(
//        sumOfDistancesInTree(
//            6,
//            edges = arrayOf(
//                intArrayOf(0, 1),
//                intArrayOf(0, 2),
//                intArrayOf(2, 3),
//                intArrayOf(2, 4),
//                intArrayOf(2, 5),
//            )
//        )
//    )
//    println(
//        sumOfDistancesInTree(
//            1,
//            arrayOf()
//        )
//    )
//    println(
//        sumOfDistancesInTree(
//            2,
//            edges = arrayOf(
//                intArrayOf(1, 0)
//            )
//        )
//    )
}