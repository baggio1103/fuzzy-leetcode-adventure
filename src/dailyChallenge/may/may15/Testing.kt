package dailyChallenge.may.may15

fun main() {
    val swappingNodes = SwappingNodes()

    printNodeValues(
        swappingNodes
            .swapNodes(
                nodeFromArray(intArrayOf(55, 60, 78, 53, 93, 37, 31, 4, 61, 11, 13, 51, 34, 83, 24, 96, 5, 77, 1, 67)),
                11
            )
    )

    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(7, 9, 6, 6, 7, 8, 3, 0, 9, 5)),
            5
        )
    )
    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(1, 2, 3, 4, 5)),
            1
        )
    )

    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(1, 2, 3, 4, 5)),
            5
        )
    )

    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(10, 20, 30)),
            2
        )
    )

    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(1, 2, 3, 4, 5)),
            2
        )
    )

    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(1, 2, 3, 4, 5)),
            3
        )
    )

    printNodeValues(swappingNodes.swapNodes(ListNode(10), 1))

    printNodeValues(
        swappingNodes.swapNodes(
            nodeFromArray(intArrayOf(10, 25)),
            1
        )
    )
}

fun printNodeValues(node: ListNode?) {
    println("-=-=-=-=-=-=-=-=-=")
    var currentNode = node
    print("[ ")
    while (currentNode != null) {
        print("${currentNode.`val`} ")
        currentNode = currentNode.next
    }
    print("]\n")
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