package bytebytego.linkedlist

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(4).apply { next = ListNode(7).apply { next = ListNode(5) } } }
    }
    val newHead = ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(4).apply { next = ListNode(7).apply { next = ListNode(5) } } }
    }
    println(reverseList(head))
    println(reverseList2(newHead))
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) return null
    var node = head
    val dummy = ListNode(-1)
    while (node != null) {
        val newNode = dummy.next
        val next = node.next
        dummy.next = node
        dummy.next?.next = newNode
        node = next
    }
    return dummy.next
}

fun reverseList2(head: ListNode?): ListNode? {
    if (head == null) return null
    var current = head
    var prev: ListNode? = null
    while (current != null) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
    }
    return prev
}
