package dailyChallenge.year2024.may.may6

fun traverse(head: ListNode?) {
    var node = head
    while (node != null) {
        println(node)
        node = node.next
    }
}

fun main() {
    val newNodes = removeNodes(
        ListNode(5).apply {
            next = ListNode(2).apply { next = ListNode(18).apply { next = ListNode(3).apply { next = ListNode(8) } } }
        }
    )
    // 18, 8
    traverse(newNodes)
}