package dailyChallenge.year2024.march.march22

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[val: $`val`]"
    }
}

fun isPalindrome(head: ListNode?): Boolean {
    var node = head
    var reversedNode = reverseList(head)
    while (node != null && reversedNode != null) {
        if (node.`val` != reversedNode.`val`) {
            return false
        }
        node = node.next
        reversedNode = reversedNode.next
    }
    return true
}

fun reverseList(head: ListNode?): ListNode? {
    var node = head
    var prev: ListNode? = null
    while (node != null) {
        prev = ListNode(node.`val`).apply { next = prev }
        if (node.next == null) return prev
        node = node.next
    }
    return null
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3)
                .apply {
                    next = ListNode(2)
                        .apply { next = ListNode(1) }
                }
        }
    }
    println(
        isPalindrome(
            head
        )
    )
}