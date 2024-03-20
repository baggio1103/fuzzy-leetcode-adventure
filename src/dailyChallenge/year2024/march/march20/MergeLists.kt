package dailyChallenge.year2024.march.march20

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[val: $`val`]"
    }
}

fun mergeInBetween(listOne: ListNode?, start: Int, end: Int, listTwo: ListNode?): ListNode? {
    val startingNode = findNode(listOne, start - 1)
    val endingNode = findNode(listOne, end + 1)
    var listTwoTail = listTwo
    while (listTwoTail?.next != null) {
        listTwoTail = listTwoTail.next
    }
    startingNode?.next = listTwo
    listTwoTail?.next = endingNode
    return listOne
}

fun findNode(head: ListNode?, n: Int): ListNode? {
    var current = 0
    var node =  head
    while (node != null) {
        if (current == n) return node
        current++
        node = node.next
    }
    return null
}
