package dailyChallenge.year2024.march.march12

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun removeZeroSumSublists(head: ListNode?): ListNode? {
    val dummy = ListNode(0).also { it.next = head }
    var prefixSum = 0
    val prefixSumMap = mutableMapOf<Int, ListNode>()
    var node: ListNode? = dummy
    while (node != null) {
        prefixSum += node.`val`
        if (prefixSumMap[prefixSum] == null) {
            prefixSumMap[prefixSum] = node
            node = node.next
            continue
        }
        val prev = prefixSumMap[prefixSum]
        var nodeToRemove = prev?.next
        var sum = prefixSum + (nodeToRemove?.`val` ?: 0)
        while (sum != prefixSum) {
            prefixSumMap.remove(sum)
            nodeToRemove = nodeToRemove?.next
            sum += (nodeToRemove?.`val` ?: 0)
        }
        prev?.next = nodeToRemove?.next
        node = node.next
    }
    return dummy.next
}

fun printList(head: ListNode?) {
    var node = head
    while (node != null) {
        print("${node.`val`}, ")
        node = node.next
    }
    println()
}

fun main() {
}
