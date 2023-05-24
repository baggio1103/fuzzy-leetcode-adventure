package dailyChallenge.may18

class SmallestNumberOfVertices {

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
        val originalNodeSet = List(n) {
                i -> i
        }.toHashSet()
        if (edges.size == 1) {
            return listOf(edges[0][0])
        }
        val map = traverse(edges)
        println("Map: $map")
        map.forEach { (key, values) ->
            values.forEach {
                if (it != key) {
                    map[it]?.let { elements ->
                        map[key] = (values + (elements) + key) as MutableSet<Int>
                    }
                }
            }
        }
        println("After manipulation: $map")
        map.forEach { (node, vertices) ->
            if (vertices.size == originalNodeSet.size) {
                return listOf(node)
            }
        }
        var nodePair = Pair(mutableListOf<Int>(), mutableSetOf<Int>())
        map.forEach { (key, nodeSet) ->
            if (nodeSet.size > nodePair.second.size) {
                nodePair = Pair(mutableListOf(key), nodeSet)
            }
        }
        val subtract = originalNodeSet.subtract(nodePair.second).toList()
        subtract.forEach { subtractNode ->
            map[subtractNode]?.let {
                nodePair.first.add(subtractNode)
                nodePair.second.addAll(
                    it
                )
            } ?: kotlin.run {
                nodePair.first.add(subtractNode)
            }
            if (nodePair.second.size == originalNodeSet.size) {
                return nodePair.first
            }
        }
        return nodePair.first
    }

    private fun traverse(
        edges: List<List<Int>>, index: Int = 0, keyIndex: Int = edges[0][0],
        map: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
    ): MutableMap<Int, MutableSet<Int>> {
        if (index > edges.lastIndex) {
            return mutableMapOf()
        }
        map[keyIndex]?.add(edges[index][1]) ?: run {
            map[keyIndex] = mutableSetOf(edges[index][1])
        }
        if (index == edges.lastIndex) {
            return mutableMapOf()
        }
        if (edges[index][1] == edges[index + 1][0]) {
            traverse(edges, index + 1, keyIndex, map)
        }
        traverse(edges, index + 1, edges[index + 1][0], map)
        return map
    }

}

fun main() {
    val smallestNumberOfVertices = SmallestNumberOfVertices()
    println(
        smallestNumberOfVertices.findSmallestSetOfVertices(
            5, listOf(
                listOf(1, 2),
                listOf(3, 2),
                listOf(4, 1),
                listOf(3, 4),
                listOf(0, 2),
                )
        )
    )
    println(
        smallestNumberOfVertices.findSmallestSetOfVertices(
            4, listOf(
                listOf(2, 0),
                listOf(0, 3),
                listOf(3, 1),
            )
        )
    )
    println(
        smallestNumberOfVertices.findSmallestSetOfVertices(6,
            listOf(
                listOf(0, 1),
                listOf(0, 2),
                listOf(2, 5),
                listOf(3, 4),
                listOf(4, 2),
            )
        )
    )
    println("-=-=-=-=-=-=-=-=-")
    println(
        smallestNumberOfVertices.findSmallestSetOfVertices(5,
            listOf(
                listOf(0, 1),
                listOf(2, 1),
                listOf(3, 1),
                listOf(1, 4),
                listOf(2, 4),
            )
        )
    )
}