package bytebytego.graphs

fun main() {
    run {
        val node0 = Node(0)
        val node1 = Node(1)
        val node2 = Node(2)

        node0.neighbors.addAll(listOf(node1, node2))
        node1.neighbors.addAll(listOf(node0, node2))
        node2.neighbors.addAll(listOf(node0, node1))
        cloneGraph(node0)
    }
}

fun cloneGraph(node: Node?): Node? {
    val nodes = mutableMapOf<Node, Node>()
    fun clone(node: Node?): Node? {
        if (node == null) return null
        if (node in nodes)
            return nodes.getValue(node)

        val newNode = Node(node.`val`)
        nodes[node] = newNode
        node.neighbors.forEach { neighbor ->
            val newNeighbor = clone(neighbor)
            newNode.neighbors.add(newNeighbor)
        }
        return newNode
    }
    return clone(node)
}
