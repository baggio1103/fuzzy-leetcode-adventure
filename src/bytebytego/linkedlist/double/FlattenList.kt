package bytebytego.linkedlist.double

fun flatten(head: ListNode?): ListNode? {
    var current = head
    while (current != null) {
        if (current.child != null) {
            var tail = current.child
            while (tail?.next != null) tail = tail.next

            tail?.next = current.next
            current.next?.prev = tail

            current.next = current.child
            current.child?.prev = current
            current.child = null
        }
        current = current.next
    }
    return head
}

class ListNode(var `val`: Int) {
    var prev: ListNode? = null
    var next: ListNode? = null
    var child: ListNode? = null
    override fun toString(): String {
        return "$`val`"
    }
}
