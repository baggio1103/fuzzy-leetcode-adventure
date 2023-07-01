package dailyChallenge.may16

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class SwappingNodesInPairs {

    fun swapPairs(head: ListNode?): ListNode? {
        val nodeMap = nodesAsList(head)
        val size = nodeMap.keys.size
        for (i in 1..size step 2 ) {
            if (i == size) {
               return nodeMap[1]
            }
            val (nodePrev, node, nodeNext) = Triple(
                nodeMap[i - 1],
                nodeMap[i],
                nodeMap[i + 1]
            )

            // 1 2 3
            var tempNode: ListNode? = null
            nodePrev?.let {
                it.next = nodeNext
            }
            nodeNext?.let {
                tempNode = it.next
                it.next = node
            }
            node?.let {
                it.next = tempNode
            }
            nodeNext?.let {
                nodeMap[i] = it
            }
            node?.let {
                nodeMap[i + 1] = it
            }
        }
        return nodeMap[1]
    }

    private fun nodesAsList(head: ListNode?): MutableMap<Int, ListNode> {
        var node = head
        val nodeMap = mutableMapOf<Int, ListNode>()
        var count = 0
        while (node != null) {
            count++
            nodeMap[count] = node
            node = node.next
        }
        return nodeMap
    }

}

fun main() {
    val swappingNodesInPairs = SwappingNodesInPairs()
    printInfo(
        swappingNodesInPairs.swapPairs(
            head = nodeFromArray(intArrayOf(1, 2, 3, 4))
        )
    )

    printInfo(
        swappingNodesInPairs.swapPairs(
            nodeFromArray(
                intArrayOf(1, 2, 3)
            )
        )
    )


    printInfo(
        swappingNodesInPairs.swapPairs(
            (ListNode(1))
        )
    )
}

fun nodeFromArray(array: IntArray): ListNode {
    val head = ListNode(array[0])
    var node = ListNode(array[1])
    head.next = node
    for (i in 2 until  array.size) {
        val newNode = ListNode(array[i])
        node.next = newNode
        node = newNode
    }
    return head
}


fun printInfo(head: ListNode?) {
    var node = head
    while (node != null) {
        print("${node.`val`} ")
        node = node.next
    }
    println("\n-=-=-=-=-=-=-=-=-=")
}