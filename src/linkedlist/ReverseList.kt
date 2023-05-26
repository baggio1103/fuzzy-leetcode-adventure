package linkedlist



class ReverseList {

    fun reverseList(head: ListNode?): ListNode? {
        var node = head
        var current: ListNode?
        var prev: ListNode? = null
        while (node != null) {
            current = ListNode(node.`val`)
            prev?.let {
                current.next = prev
            }
            prev = current
            node = node.next
            if (node == null) {
                return current
            }
        }
        return null
    }

}

fun main() {

    val reverseList = ReverseList()
    val head = ListNode(1).also { head ->
        head.next = ListNode(4).also {
            it.next = ListNode(12)
        }
    }
    val reversedNode = reverseList.reverseList(head)
    reversedNode?.info()


}