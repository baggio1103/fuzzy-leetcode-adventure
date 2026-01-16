package dailyChallenge.year2026.january.january16

import kotlin.math.abs

fun main() {
    println(
        maximizeSquareArea(4, 3, intArrayOf(2, 3), intArrayOf(2))
    )
    println(
        maximizeSquareArea(6, 7, intArrayOf(2), intArrayOf(4))
    )
    println(
        maximizeSquareArea(6, 7, intArrayOf(2), intArrayOf(5))
    )
}

fun maximizeSquareArea(m: Int, n: Int, hFences: IntArray, vFences: IntArray): Int {
    var side = 0
    val mod = 1_000_000_007
    val hEdges = getEdges(hFences, m)
    val vEdges = getEdges(vFences, n)
    for (vEdge in vEdges) {
        if (vEdge in hEdges) {
            side = maxOf(vEdge, side)
        }
    }
    return if (side == 0) -1 else ((side.toLong() * side) % mod).toInt()
}

fun getEdges(fences: IntArray, border: Int): Set<Int> {
    val allFences = mutableListOf(1)
    fences.forEach { fence -> allFences.add(fence) }
    allFences.add(border)
    val edges = mutableSetOf<Int>()
    for (i in allFences.indices) {
        for (j in i + 1 until allFences.size) {
            edges.add(abs(allFences[j] - allFences[i]))
        }
    }
    return edges
}
