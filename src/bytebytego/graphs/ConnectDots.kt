package bytebytego.graphs

import kotlin.math.abs

fun main() {
    println(
        minCostConnectPoints(
            arrayOf(intArrayOf(1, 1), intArrayOf(2, 6), intArrayOf(3, 2), intArrayOf(4, 3), intArrayOf(7, 1)),
        )
    )
}

fun minCostConnectPoints(points: Array<IntArray>): Int {
    val n = points.size
    val unionFind = UnionFind(n)
    val edges = mutableListOf<IntArray>()
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            edges.add(
                intArrayOf(
                    i,
                    j,
                    abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                )
            )
        }
    }
    edges.sortBy { it[2] }
    var minCost = 0
    var edgesCount = 0
    for ((x, y, cost) in edges) {
        if (unionFind.merge(x, y)) {
            minCost += cost
            edgesCount++
        }
        if (edgesCount == n - 1) break
    }
    return minCost
}

class UnionFind(n: Int) {

    val nodes = IntArray(n) { it }

    fun find(i: Int): Int {
        if (i == nodes[i]) return i
        return find(nodes[i])
    }

    fun merge(x: Int, y: Int): Boolean {
        val xRep = find(x)
        val yRep = find(y)
        if (xRep == yRep) return false
        nodes[xRep] = yRep
        return true
    }

}
