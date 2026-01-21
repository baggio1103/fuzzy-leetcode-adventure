package bytebytego.linkedlist

import bytebytego.linkedlist.FlattenMultiLevelList.ListNode

fun main() {
    val node = ListNode(1)
        .apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        child = ListNode(7).apply {
                            next = ListNode(8)
                            child = ListNode(10)
                        }
                    }
                }
            }
            child = ListNode(5).apply {
                next = ListNode(6).apply {
                    child = ListNode(9)
                }
            }
        }
    var newNode = flatten(node)
    while (newNode != null) {
        println(newNode)
        newNode = newNode.next
    }
}

fun flatten(head: ListNode?): ListNode? {
    var tail = head
    while (tail?.next != null)
        tail = tail.next
    var current = head
    while (current != null) {
        if (current.child != null) {
            tail?.next = current.child
            current.child = null
            while (tail?.next != null)
                tail = tail.next
        }
        current = current.next
    }
    return head
}

object FlattenMultiLevelList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
        var child: ListNode? = null
        override fun toString(): String {
            return "$`val`"
        }
    }
}