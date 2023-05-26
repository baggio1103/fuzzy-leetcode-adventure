package linkedlist
class HasListCycle {

    fun hasCycle(head: ListNode?): Boolean {
        val set = HashSet<ListNode>()
        var node = head
        while (node != null) {
            if (set.contains(node)) {
                return true
            } else {
                set.add(node)
            }
            node = node.next
        }
        return false
    }

}


fun main() {
    val listCycle = HasListCycle()
    val head = ListNode(1).also { head ->
        head.next = ListNode(4).also {
            it.next = ListNode(12).also {
                it.next = head
            }
        }
    }
    println(
        listCycle.hasCycle(head)
    )
}