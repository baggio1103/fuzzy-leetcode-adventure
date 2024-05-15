package dailyChallenge.year2024.may.may15

import java.util.PriorityQueue
import java.util.ArrayDeque

fun maximumSafenessFactor(grid: List<List<Int>>): Int {
    val size = grid.size
    fun inBounds(row: Int, col: Int) = minOf(row, col) >= 0 && maxOf(row, col) < size
    fun preCompute(): Map<String, Int> {
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val midDist = mutableMapOf<String, Int>()
        for (r in 0 until size) {
            for (c in 0 until size) {
                if (grid[r][c] == 1) {
                    queue.offer(Triple(r, c, 0))
                    midDist["$r-$c"] = 0
                }
            }
        }
        while (queue.isNotEmpty()) {
            val (r, c, dist) = queue.poll()
            listOf(Pair(r - 1, c), Pair(r + 1, c), Pair(r, c - 1), Pair(r, c + 1))
                .forEach { (row, col) ->
                    val key = "$row-$col"
                    if (key !in midDist && inBounds(row, col)) {
                        queue.offer(Triple(row, col, dist + 1))
                        midDist[key] = dist + 1
                    }
                }
        }
        return midDist
    }

    val distMap = preCompute()
    val heap = PriorityQueue(compareBy<Triple<Int, Int, Int>> { it.first }.reversed())
    heap.offer(Triple(distMap.getValue("0-0"), 0, 0))
    val visited = hashSetOf<String>()
    visited.add("0-0")
    while (heap.isNotEmpty()) {
        val (dist, r, c) = heap.poll()
        if (r == size - 1 && c == size - 1)
            return dist
        val neighbours = listOf(Pair(r - 1, c), Pair(r + 1, c), Pair(r, c - 1), Pair(r, c + 1))
        for ((row, col) in neighbours) {
            val key = "$row-$col"
            if (inBounds(row, col) && key !in visited) {
                val minDist = minOf(dist, distMap.getValue("$row-$col"))
                visited.add(key)
                heap.offer(Triple(minDist, row, col))
            }
        }
    }
    return -1
}

fun main() {
    println(
        maximumSafenessFactor(
            grid = listOf(
                listOf(0, 0, 1),
                listOf(0, 0, 1),
                listOf(0, 0, 1),
            )
        )
    )
    println(
        maximumSafenessFactor(
            grid = listOf(
                listOf(0, 0, 1),
                listOf(0, 0, 0),
                listOf(0, 0, 0),
            )
        )
    )
}