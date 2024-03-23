package dailyChallenge.year2024.march.march23

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[$`val`]"
    }
}

fun reorderList(head: ListNode?) {
    var node = head
    val nodes = mutableListOf<ListNode>()
    while (node != null) {
        nodes.add(ListNode(node.`val`))
        node = node.next
    }
    var iteratorNode: ListNode? = ListNode(0)
    val dummy: ListNode = ListNode(-1).apply { next = iteratorNode }
    var i = 0
    var j = nodes.lastIndex
    while (i <= j) {
        if (i == j) {
            iteratorNode?.next = nodes[i]
            break
        }
        iteratorNode?.next = nodes[i]
        iteratorNode = iteratorNode?.next
        iteratorNode?.next = nodes[j]
        iteratorNode = iteratorNode?.next
        i++
        j--
    }
    head?.next = dummy.next?.next?.next
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }
    reorderList(head)
    var node: ListNode? = head
    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}