package bytebytego.graphs

import java.util.PriorityQueue

fun main() {
    println(
        shortestPath(
            6,
            arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(0, 2, 3),
                intArrayOf(1, 2, 1),
                intArrayOf(1, 3, 4),
                intArrayOf(2, 3, 4),
                intArrayOf(2, 4, 5)
            )
        ).contentToString()
    )
}

fun shortestPath(n: Int, edges: Array<IntArray>): IntArray {
    val distances = IntArray(n) { Int.MAX_VALUE }
    distances[0] = 0
    val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    for ((x, y, weight) in edges) {
        graph.getOrPut(x) { mutableListOf() }.add(Pair(y, weight))
        graph.getOrPut(y) { mutableListOf() }.add(Pair(x, weight))
    }
    // neighbor, weight
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy { (_, distance) -> distance })
    queue.add(Pair(0, 0))
    while (queue.isNotEmpty()) {
        val (currNode, curDistance) = queue.poll()
        for ((neighbor, neighborDistance) in graph.getValue(currNode)) {
            val distance = curDistance + neighborDistance
            if (distance < distances[neighbor]) {
                distances[neighbor] = distance
                queue.add(neighbor to distance)
            }
        }
    }
    return IntArray(n) { index ->
        if (distances[index] == Int.MAX_VALUE) -1 else distances[index]
    }
}
