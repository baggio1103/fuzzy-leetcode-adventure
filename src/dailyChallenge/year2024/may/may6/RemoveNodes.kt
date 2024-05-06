package dailyChallenge.year2024.may.may6

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[val: $`val`]"
    }
}

fun removeNodes(head: ListNode?): ListNode {
    val array = makeList(head)
    var node = array.last()
    for (i in array.lastIndex - 1 downTo 0) {
        if (i == 0 && array[i].`val` < node.`val`) {
            array[0].`val` = node.`val`
            array[0].next = node.next
            continue
        }
        if (array[i].`val` < node.`val`) {
            continue
        }
        array[i].next = node
        node = array[i]
    }
    return array[0]
}

fun makeList(head: ListNode?): Array<ListNode> {
    var node = head
    val list = mutableListOf<ListNode>()
    while (node != null) {
        list.add(node)
        node = node.next
    }
    return list.toTypedArray()
}