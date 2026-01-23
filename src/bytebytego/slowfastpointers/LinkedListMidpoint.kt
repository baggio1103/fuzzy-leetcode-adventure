package bytebytego.slowfastpointers

fun main() {
    val listOne = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } }
        }
    }
    println(middleNode(listOne))

    val listTwo = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(7).apply { next = ListNode(4) }
        }
    }
    println(middleNode(listTwo))
}

fun middleNode(head: ListNode?): ListNode? {
    var fast = head
    var slow = head
    while (fast?.next != null) {
        fast = fast.next?.next
        slow = slow?.next
    }
    return slow
}

