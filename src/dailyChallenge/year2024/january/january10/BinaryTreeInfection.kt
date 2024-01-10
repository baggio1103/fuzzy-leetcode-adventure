package dailyChallenge.year2024.january.january10

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


data class Vertex(
    val value: Int,
    var isVisited: Boolean,
    var distance: Int = 0
)

fun amountOfTime(root: TreeNode?, start: Int): Int {
    if (root == null) {
        return 0
    }
    if (root.left == null && root.right == null) {
        return 0
    }
    val graph = rootToGraph(root)
    val vertices = graph.map { Vertex(it.key, false) }.associateBy { it.value }
    val startingPoint = graph.getValue(start)
    vertices[start]?.isVisited = true
    val queue = Stack<Int>().apply {
        startingPoint.forEach {
            push(it)
            vertices[it]?.isVisited = true
            vertices[it]?.distance = 1
        }
    }
    while (queue.isNotEmpty()) {
        val vertexValue = queue.pop()
        val adjacentNodes = graph.getValue(vertexValue).filter {
            !vertices.getValue(it).isVisited
        }
        if (adjacentNodes.isEmpty()) {
            continue
        }
        adjacentNodes.forEach {
            queue.push(it)
            vertices[it]?.isVisited = true
            vertices[it]?.distance = 1 + (vertices[vertexValue]?.distance ?: 0)
        }
    }
    return vertices.values.maxOf { it.distance }
}

fun rootToGraph(root: TreeNode?): MutableMap<Int, MutableList<Int>> {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    fun traverse(root: TreeNode?) {
        if (root == null) {
            return
        }
        val rootValues = graph.getOrDefault(root.`val`, mutableListOf())
        root.left?.let { leftNode ->
            rootValues.add(leftNode.`val`)
            val leftNodeValues = graph[leftNode.`val`] ?: mutableListOf(root.`val`)
            graph[leftNode.`val`] = leftNodeValues
        }
        root.right?.let { rightNode ->
            rootValues.add(rightNode.`val`)
            val leftNodeValues = graph[rightNode.`val`] ?: mutableListOf(root.`val`)
            graph[rightNode.`val`] = leftNodeValues
        }
        graph[root.`val`] = rootValues
        traverse(root.left)
        traverse(root.right)
    }
    traverse(root)
    return graph
}


fun main() {
    val root = TreeNode(1).also {
        it.left = TreeNode(5).also {
            it.right = TreeNode(4).also {
                it.left = TreeNode(9)
                it.right = TreeNode(2)
            }
        }

        it.right = TreeNode(3).also {
            it.left = TreeNode(10)
            it.right = TreeNode(6)
        }
    }
    println(
        amountOfTime(root, 3)
    )
    println(
        amountOfTime(
            TreeNode(1).also {
                it.left = TreeNode(2).also {
                    it.left = TreeNode(3).also {
                        it.left = TreeNode(4).also {
                            it.left = TreeNode(5)
                        }
                    }
                }
            },
            1,
        )
    )
}