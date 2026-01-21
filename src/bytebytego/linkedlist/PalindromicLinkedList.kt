package bytebytego.linkedlist

fun main() {
    val list = ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(2).apply { next = ListNode(1) } } }
    }

    println(isPalindrome(list))
}

fun isPalindrome(head: ListNode): Boolean {
    var left: ListNode? = head
    val midPoint = middlePoint(head)
    var right = reverse(midPoint)
    while (left != null && right != null) {
        if (left.`val` != right.`val`) return false
        left = left.next
        right = right.next
    }
    return true
}

fun reverse(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}

fun middlePoint(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    while (slow != null && fast != null) {
        slow = slow.next
        fast = fast.next?.next
    }
    return slow
}
