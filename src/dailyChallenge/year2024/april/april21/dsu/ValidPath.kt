package dailyChallenge.year2024.april.april21.dsu

fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
    val dsu = DisjointSetUnion(IntArray(n) { it })
    edges.forEach { (from, to) ->
        dsu.union(from, to)
    }
    return dsu.isConnected(source, destination)
}

fun main() {
    println(
        validPath(
            10,
            arrayOf(
                intArrayOf(4, 3),
                intArrayOf(1, 4),
                intArrayOf(4, 8),
                intArrayOf(1, 7),
                intArrayOf(6, 4),
                intArrayOf(4, 2),
                intArrayOf(7, 4),
                intArrayOf(4, 0),
                intArrayOf(0, 9),
                intArrayOf(5, 4)
            ),
            5,
            9
        )
    )
}