package dailyChallenge.may15

import kotlin.math.absoluteValue
import kotlin.math.min

class ListNode(var value: Int) {
     var next: ListNode? = null
 }

class SwappingNodes {

    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }
        val (starting, ending, nodes) = nodes(head, k)
        var currentNode = starting
        for (i in nodes.lastIndex downTo 0) {
            currentNode.next = nodes[i]
            currentNode = currentNode.next ?: throw IllegalArgumentException("Value cannot be null")
        }
        currentNode.next = ending
        return head
    }

    private fun nodes(head: ListNode?, k: Int): Triple<ListNode, ListNode, List<ListNode>> {
        val nodes = mutableListOf<ListNode>()
        var node = head
        while (node != null) {
            nodes.add(node)
            node = node.next
        }
        return if (nodes.size > 1) {
            Triple(
                nodes[k.minus(2).absoluteValue],
                nodes[min(nodes.size - k + 1, nodes.lastIndex)],
                nodes.let { it.subList(k - 1, it.size - k + 1) }
            )

        } else {
            Triple(
                nodes[0],
                nodes[0],
                nodes
            )
        }
    }

}

fun main() {
    val swappingNodes = SwappingNodes()
    val head = ListNode(1).also {
        it.next = ListNode(2).also {
            it.next = ListNode(3).also {
                it.next = ListNode(4).also {
                    it.next = ListNode(5)
                }
            }
        }
    }
    val node = swappingNodes.swapNodes(head, 2)
    printInfo(node)
//    printInfo(
//        swappingNodes.swapNodes(ListNode(1), 1)
//    )
    printInfo(
        swappingNodes.swapNodes(ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3)
            }
        }, 1)
    )
}

fun printInfo(node: ListNode?) {
    var currentNode = node
    while (currentNode != null) {
        println(currentNode.value)
        currentNode = currentNode.next
    }
}