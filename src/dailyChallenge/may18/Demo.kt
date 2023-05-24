package dailyChallenge.may18

fun traverse(
    edges: List<List<Int>>, index: Int = 0, keyIndex: Int = edges[0][0],
    map: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
): MutableMap<Int, MutableSet<Int>> {
    if (edges.size == 1) {
        return mutableMapOf(
            edges[0][0] to mutableSetOf(edges[0][1])
        )
    }
    if (index > edges.lastIndex) {
        return mutableMapOf()
    }

    map[keyIndex]?.add(edges[index][1]) ?: run {
        map[keyIndex] = mutableSetOf(edges[index][1])
    }
    if (index == edges.lastIndex ) {
        return mutableMapOf()
    }
    traverse(edges, index + 1, edges[index + 1][0], map)
    return map
}

fun group(edges: List<List<Int>>) {
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
                println("Before $nodeMap")
                nodeMap[edge[0]] = HashSet(newHashSet)
                nodeMap.remove(edge[1])
                println("Edge  $edge, After $nodeMap")
            } ?: run {
                val hashSet = HashSet<Int>()
                hashSet.add(edge[1])
                nodeMap[edge[0]] = hashSet
            }
        }
    }
    println("$nodeMap + Vertices: ${nodeMap.keys.toList()}")
}

fun findNodeAmongValues(map: MutableMap<Int, HashSet<Int>>, value: Int): Int? {
    map.forEach { (key, values) ->
        if (key == value || values.contains(value)) {
            return key
        }
    }
    return null
}

fun findKey(map: MutableMap<Int, HashSet<Int>>, value: Int): Int? {
    return if (map[value] != null) value else null
}

fun main() {

    group(
        listOf(
            listOf(1, 2),
            listOf(3, 2),
            listOf(4, 1),
            listOf(3, 4),
            listOf(0, 2),
        )
    )

    group(
        listOf(
            listOf(0, 1),
            listOf(0, 2),
            listOf(1, 19),
            listOf(2, 3),
            listOf(5, 5),
            listOf(6, 6)
        )
    )
    group(
        listOf(
            listOf(0, 1),
            listOf(1, 2),
            listOf(1, 4),
            listOf(4, 3),
        )
    )
    group(
        listOf(
            listOf(0, 1)
        )
    )
    group(
        listOf(
            listOf(0, 1),
            listOf(0, 2),
            listOf(1, 19),
            listOf(2, 3),
            listOf(5, 5),
            listOf(6, 6)
        )
    )
    group(
        listOf(
            listOf(2, 0),
            listOf(0, 3),
            listOf(3, 1),
        )
    )
    group(
        listOf(
            listOf(1, 2),
            listOf(3, 2),
            listOf(4, 1),
            listOf(3, 4),
            listOf(0, 2),
        )
    )
    println("-=-=--=-=-=-=-=-=-=-=-=")
    println(
        traverse(
            listOf(
                listOf(0, 1),
                listOf(0, 2),
                listOf(1, 19),
                listOf(2, 3),
                listOf(5, 5),
                listOf(6, 6)
            )
        )
    )
    println(
        traverse(
            listOf(
                listOf(2, 0),
                listOf(0, 3),
                listOf(3, 1),
            )
        )
    )
    println(
        traverse(
            listOf(
                listOf(0, 2),
                listOf(1, 0),
                listOf(1, 2),
            )
        )
    )
//    [0,1],[0,2],[2,5],[3,4],[4,2]
    println(
        traverse(
            listOf(
                listOf(0, 1),
                listOf(0, 2),
                listOf(2, 5),
                listOf(3, 4),
                listOf(4, 2),
            )
        )
    )

    println(
        traverse(
            listOf(
                listOf(0, 1),
                listOf(2, 2)
            )
        )
    )

}

