package dailyChallenge.may.may18

class SmallestNumberOfVertices {

    fun findSmallestSetOfVertices(edges: List<List<Int>>): List<Int> {
        val nodeMap = mutableMapOf<Int, HashSet<Int>>()
        edges.forEach { edge ->
            if (edge[0] == 3 && edge[1] == 4) {
                println(findNodeAmongValues(nodeMap, edge[0]))
                println(findKey(nodeMap, edge[1]))
            }
            findNodeAmongValues(nodeMap, edge[0])?.let { index ->
                findKey(nodeMap, edge[1])?.let {

                }?: run {
                    nodeMap[index]?.add(edge[1])
                }
            } ?: run {
                findKey(nodeMap, edge[1])?.let { index ->
                    val values = nodeMap[index] ?: throw IllegalArgumentException("Exception")
                    val newHashSet = HashSet<Int>(1 + values.size)
                    values.let {
                        newHashSet.addAll(it)
                    }
                    newHashSet.addAll(values)
                    newHashSet.add(edge[1])
                    nodeMap[edge[0]] = HashSet(newHashSet)
                    nodeMap.remove(edge[1])
                } ?: run {
                    val hashSet = HashSet<Int>()
                    hashSet.add(edge[1])
                    nodeMap[edge[0]] = hashSet
                }
            }
        }
        return nodeMap.keys.toList()
    }

    private fun findNodeAmongValues(map: MutableMap<Int, HashSet<Int>>, value: Int): Int? {
        map.forEach { (key, values) ->
            if (key == value || values.contains(value)) {
                return key
            }
        }
        return null
    }

    private fun findKey(map: MutableMap<Int, HashSet<Int>>, value: Int): Int? {
        return if (map[value] != null) value else null
    }

}

fun main() {
    val smallestNumberOfVertices = SmallestNumberOfVertices()
    println(
        smallestNumberOfVertices.findSmallestSetOfVertices(
            listOf(
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
            listOf(
                listOf(2, 0),
                listOf(0, 3),
                listOf(3, 1),
            )
        )
    )
    println(
        smallestNumberOfVertices.findSmallestSetOfVertices(
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
        smallestNumberOfVertices.findSmallestSetOfVertices(
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