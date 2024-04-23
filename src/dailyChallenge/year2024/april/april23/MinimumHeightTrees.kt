package dailyChallenge.year2024.april.april23

import java.util.ArrayDeque

fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
    if (n == 1) return emptyList()
    val adjMap = mutableMapOf<Int, MutableList<Int>>()
    var nodeCount = n
    for ((from, to) in edges) {
        adjMap[from]?.add(to) ?: run { adjMap[from] = mutableListOf(to) }
        adjMap[to]?.add(from) ?: run { adjMap[to] = mutableListOf(from) }
    }
    val edgeCount = mutableMapOf<Int, Int>()
    val leaves = ArrayDeque<Int>()
    for ((src, neighbours) in adjMap) {
        if (neighbours.size == 1) {
            leaves.push(src)
        }
        edgeCount[src] = neighbours.size
    }
    while (leaves.isNotEmpty()) {
        if (nodeCount <= 2) return leaves.toList()
        for (i in leaves.indices) {
            val node = leaves.pop()
            nodeCount--
            val neighbours = adjMap[node] ?: continue
            for (nei in neighbours) {
                val count = edgeCount[nei] ?: continue
                edgeCount[nei] = count - 1
                if (edgeCount[nei] == 1) {
                    leaves.offer(nei)
                }
            }
        }
    }
    return emptyList()
}

fun main() {

    println(
        findMinHeightTrees(
            10,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(0, 3),
                intArrayOf(2, 4),
                intArrayOf(0, 5),
                intArrayOf(5, 6),
                intArrayOf(6, 7),
                intArrayOf(2, 8),
                intArrayOf(7, 9),
            )
        )
    )
    println(
        findMinHeightTrees(
            4,
            arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(1, 3),
            )
        )
    )
}