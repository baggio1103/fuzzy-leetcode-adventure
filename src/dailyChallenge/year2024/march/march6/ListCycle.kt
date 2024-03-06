package dailyChallenge.year2024.march.march6

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun hasCycle(head: ListNode?): Boolean {
    var tortoise = head
    var heir = head
    while (heir?.next != null) {
        heir = heir.next?.next
        tortoise = tortoise?.next
        if (heir == tortoise) {
            return true
        }
    }
    return false
}

fun main() {
    val node = ListNode(2)
    println(
        hasCycle(ListNode(3).apply {
            next = node.apply {
                next = ListNode(0).apply {
                    next = ListNode(4)
                }
            }
        })
    )
}
