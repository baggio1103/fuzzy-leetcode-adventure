package bytebytego.graphs

fun main() {
    require(
        isBipartite(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(0, 2),
                intArrayOf(1, 3),
                intArrayOf(0, 2),
            )
        )
    )
    require(
        !isBipartite(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(0, 2),
                intArrayOf(0, 1, 3),
                intArrayOf(0, 2),
            )
        )
    )
    require(
        isBipartite(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(0, 2),
                intArrayOf(1),
                intArrayOf(4),
                intArrayOf(0, 3),
            )
        )
    )
    require(
        isBipartite(
            arrayOf(
                intArrayOf(),
                intArrayOf(),
                intArrayOf(),
            )
        ),
    )
    require(
        isBipartite(
            graph = arrayOf(
                intArrayOf(1),
                intArrayOf(0, 3),
                intArrayOf(3),
                intArrayOf(1, 2),
            )
        )
    )
}

fun isBipartite(graph: Array<IntArray>): Boolean {
    val colors = IntArray(graph.size)

    fun dfs(i: Int, color: Int): Boolean {
        colors[i] = color
        for (neighbor in graph[i]) {
            if (colors[neighbor] == color) return false
            if (colors[neighbor] == 0 && !dfs(neighbor, -color)) return false
        }
        return true
    }

    for (i in graph.indices) {
        if (colors[i] == 0 && !dfs(i, 1))
            return false
    }
    return true
}
