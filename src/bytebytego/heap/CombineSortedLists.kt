package bytebytego.heap

import java.util.PriorityQueue

fun main() {
    val nodeOne = ListNode(1).apply { next = ListNode(3).apply { next = ListNode(4) } }
    val nodeTwo = ListNode(1).apply { next = ListNode(4).apply { next = ListNode(5) } }
    val nodeThree = ListNode(2).apply { next = ListNode(6) }
    val node = combineLists(arrayOf(nodeOne, nodeTwo, nodeThree))
    printNodeList(node)
}

fun printNodeList(node: ListNode?) {
    var cur = node
    while (cur != null) {
        print("${cur.`val`} ")
        cur = cur.next
    }
    println()
}

fun combineLists(lists: Array<ListNode>): ListNode? {
    if (lists.isEmpty()) return null
    val dummy = ListNode(-1)
    val queue = PriorityQueue<ListNode>(compareBy { it.`val` })
    lists.forEach { node -> queue.offer(node) }
    var curr: ListNode? = dummy
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        curr?.next = node
        curr = curr?.next
        if (node.next != null)
            queue.offer(node.next)
    }
    return dummy.next
}

class ListNode(val `val`: Int) {
    var next: ListNode? = null
}
