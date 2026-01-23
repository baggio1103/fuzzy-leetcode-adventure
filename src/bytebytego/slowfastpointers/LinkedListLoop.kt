package bytebytego.slowfastpointers

fun main() {
    println(hasCycle(ListNode(1)))
    val head = ListNode(0)
    println(hasCycle(head.apply { next = ListNode(2).apply { next = head } }))
}

fun hasCycle(head: ListNode?): Boolean {
//    if (head?.next == null) return false
    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
        if (fast == slow) return true
    }
    return false
}

