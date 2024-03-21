package dailyChallenge.year2024.march.march21

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        var node: ListNode? = this
        return buildString {
            append("Node: [")
            while (node != null) {
                append(" ${node?.`val`} ")
                node = node?.next
            }
            append("]")
        }
    }
}

fun reverseList(head: ListNode?): ListNode? {
    var node = head
    var prev: ListNode? = null
    while (node != null) {
        prev = ListNode(node.`val`).apply { next = prev }
        if (node.next == null) {
            return prev
        }
        node = node.next
    }
    return null
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
    }
    println(head)
    val reversed = reverseList(head)
    println(
        reversed
    )
}
