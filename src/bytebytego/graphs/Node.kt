package bytebytego.graphs

class Node(
    val `val`: Int?,
    val neighbors: MutableList<Node?> = mutableListOf(),
) {
    override fun toString(): String {
        return "Node{val: ${`val`}}"
    }
}