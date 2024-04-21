package dailyChallenge.year2024.april.april21.dfs

import java.util.Stack

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    if (n == 1) return false
    val adjacentVertices = mutableMapOf<Int, MutableList<Int>>()
    edges.forEach { (from, to) ->
        adjacentVertices[from]?.add(to) ?: run { adjacentVertices[from] = mutableListOf(to) }
        adjacentVertices[to]?.add(from) ?: run { adjacentVertices[to] = mutableListOf(from) }
    }
    val stack = Stack<Pair<Int, Int>>()
    val set = hashSetOf<String>()
    adjacentVertices[source]?.forEach { to -> stack.push(Pair(source, to)) }
    while (stack.isNotEmpty()) {
        val (_, to) = stack.pop()
        if (to == destination) {
            return true
        }
        val vertices = adjacentVertices[to] ?: continue
        vertices.forEach { dest ->
            if (dest == destination) return true
            val (keyOne, keyTwo) = Pair("$to-$dest", "$dest-$to")
            if (set.contains(keyOne) && set.contains(keyTwo)) {
                return@forEach
            }
            stack.push(Pair(to, dest))
            set.add(keyOne)
        }
    }
    return false
}

fun main() {

    println(
        validPath(
            10,
            arrayOf(
                intArrayOf(2, 9),
                intArrayOf(7, 8),
                intArrayOf(5, 9),
                intArrayOf(7, 2),
                intArrayOf(3, 8),
                intArrayOf(2, 8),
                intArrayOf(1, 6),
                intArrayOf(3, 0),
                intArrayOf(7, 0),
                intArrayOf(8, 5)
            ),
            1,
            0
        )
    )


    println(
        validPath(
            3,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 2),
                intArrayOf(2, 0)
            ),
            0,
            2
        )
    )
}