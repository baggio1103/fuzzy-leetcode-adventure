package dailyChallenge.year2024.january.january10.opt

import java.util.*


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun amountOfTime(root: TreeNode?, start: Int): Int {
    if (root == null) {
        return 0
    }
    if (root.left == null && root.right == null) {
        return 0
    }
    val graph = rootToGraph(root)
    val queue: Queue<Int> = LinkedList<Int>().apply {
        offer(start)
    }
    val visitedVertices = mutableSetOf(start)
    var size = 1
    var distance = 0
    while (queue.isNotEmpty()) {
        var counter = 0
        repeat(size) {
            val adjacentNode = queue.poll()
            val nodes = graph[adjacentNode]?.filter { !visitedVertices.contains(it) } ?: return@repeat
            nodes.forEach {
                queue.offer(it)
                visitedVertices.add(it)
                counter++
            }
            size = counter
        }
        if (counter != 0) {
            distance++
        }
    }
    return distance
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
    val rootTwo = TreeNode(1).also {
        it.left = TreeNode(2).also {
            it.left = TreeNode(3).also {
                it.left = TreeNode(4).also {
                    it.left = TreeNode(5)
                }
            }
        }
    }
    IntRange(1, 5).forEach {
        println("Result with start at: $it = ${amountOfTime(rootTwo, it)}")
    }
}