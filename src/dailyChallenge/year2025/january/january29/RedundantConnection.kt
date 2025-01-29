package dailyChallenge.year2025.january.january29

fun main() {
//    [[1,2],[1,3],[2,3]]
    println(
        findRedundantConnection(
            edges = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(2, 3)
            )
        ).contentToString()
    )
    println(
        findRedundantConnection(
            edges = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(1, 4),
                intArrayOf(1, 5)
            )
        ).contentToString()
    )

    val nodes = intArrayOf(0, 1, 1, 1)

}


fun findRedundantConnection(edges: Array<IntArray>): IntArray {
    val length = edges.size + 1
    val nodes = IntArray(length) { it }

    fun getParent(value: Int): Int = if (nodes[value] == value) value else getParent(nodes[value])

    for (edge in edges) {
        val src = getParent(edge[0])
        val destination = getParent(edge[1])
        if (src == destination) {
            return edge
        }
        nodes[destination] = nodes[src]
    }
    return intArrayOf()
}