package linkedlist

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun ListNode.info() {
    var node: ListNode? = this
    while (node != null) {
        print("${node.`val`} ")
        node = node.next
    }
    println()
}