package dailyChallenge.year2024.march.march3

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[val: $`val`]"
    }
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    var node = head
    val size = size(head)
    if ((size - n) == 0) {
        node = node?.next
        return node
    }
    var prevNode: ListNode? = null
    repeat((size - n)) { index ->
        if ((size - n) - 1 == index) {
            prevNode = node
        }
        node = node?.next
    }
    prevNode?.next = node?.next
    return head
}

fun size(head: ListNode?): Int {
    var count = 0
    var node = head
    while (node != null) {
        count++
        node = node.next
    }
    return count
}

fun traverse(node: ListNode?) {
    var head = node
    while (head != null) {
        print("${head.`val`} -> ")
        head = head.next
    }
    println()
}

fun main() {
    val nodeOne = removeNthFromEnd(
        ListNode(1).apply {
            next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
        }, 1
    )
    traverse(nodeOne)
    val nodeTwo = removeNthFromEnd(
        ListNode(1).apply {
            next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
        }, 2
    )
    traverse(nodeTwo)
    val nodeThree = removeNthFromEnd(
        ListNode(1).apply {
            next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
        }, 3
    )
    traverse(nodeThree)
    val nodeFour = removeNthFromEnd(
        ListNode(1).apply {
            next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
        }, 4
    )
    traverse(nodeFour)
    val nodeFive = removeNthFromEnd(
        ListNode(1).apply {
            next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4).apply { next = ListNode(5) } } }
        }, 5
    )
    traverse(nodeFive)

    traverse(
        removeNthFromEnd(ListNode(1), 1)
    )

}
