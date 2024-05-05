package dailyChallenge.year2024.may.may5

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[val: $`val`]"
    }
}

fun deleteNode(node: ListNode?) {
    node?.`val` = node?.next?.`val` ?: throw IllegalArgumentException()
    node.next = node.next?.next
}

fun traverse(head: ListNode?) {
    var node = head
    while (node != null) {
        println(node)
        node = node.next
    }
}


fun main() {
    val middleNode = ListNode(3)
    val node = ListNode(1).apply {
        next = ListNode(2).apply {
            next = middleNode.apply {
                next = ListNode(4).apply { next = ListNode(5) }
            }
        }
    }
    traverse(node)
    deleteNode(middleNode)
    traverse(node)
}
