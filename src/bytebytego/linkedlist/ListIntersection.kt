package bytebytego.linkedlist

fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var nodeA = headA
    var nodeB = headB
    while (nodeA != nodeB) {
        nodeA = if (nodeA == null) headB else nodeA.next
        nodeB = if (nodeB == null) headA else nodeB.next
        nodeA = nodeA?.next
        nodeB = nodeB?.next
        if (nodeA == null) nodeA = headB
        if (nodeB == null) nodeB = headA
    }
    return nodeA
}
