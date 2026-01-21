package bytebytego.linkedlist

fun main() {
    val list = ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
    }
    val head = removeNthFromEnd(list, 20)
    println(head == list)

}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(-1).apply { next = head }
    var leader: ListNode? = dummy
    var trailer: ListNode? = dummy
    repeat(n + 1) {
        leader = leader?.next
    }
    while (leader != null) {
        trailer = trailer?.next
        leader = leader?.next
    }
    trailer?.next = trailer?.next?.next
    return dummy.next
}
