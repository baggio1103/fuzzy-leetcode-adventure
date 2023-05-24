package dailyChallenge.may18


fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
    val nodes = IntArray(n)
    edges.forEach { edge ->
        nodes[edge[1]] = 1
    }
    val unreachableNodes = mutableListOf<Int>()
    nodes.forEachIndexed { index, node ->
        if (node == 0) {
            unreachableNodes.add(index)
        }
    }
    return unreachableNodes
}

fun main() {
    println(
        findSmallestSetOfVertices(
            5,
            listOf(
                listOf(0, 1),
                listOf(1, 2),
                listOf(1, 4),
                listOf(4, 3),
            )
        )
    )
    findSmallestSetOfVertices(2,
        listOf(
            listOf(0, 1)
        )
    ).let {
        println(it)
    }
    findSmallestSetOfVertices(8,
        listOf(
            listOf(0, 1),
            listOf(0, 2),
            listOf(1, 7),
            listOf(2, 3),
            listOf(5, 5),
            listOf(6, 6)
        )
    ).let {
        println(it)
    }
    findSmallestSetOfVertices(4,
        listOf(
            listOf(2, 0),
            listOf(0, 3),
            listOf(3, 1),
        )
    ).let {
        println(it)
    }
    findSmallestSetOfVertices(5,
        listOf(
            listOf(1, 2),
            listOf(3, 2),
            listOf(4, 1),
            listOf(3, 4),
            listOf(0, 2),
        )
    ).let {
        println(it)
    }
}

