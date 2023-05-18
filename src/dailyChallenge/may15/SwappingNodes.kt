package dailyChallenge.may15

import kotlin.math.max
import kotlin.math.min

class ListNode(var `val`: Int) {
     var next: ListNode? = null
 }

class SwappingNodes {

    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        val nodeMap = nodes(head)
        val size = nodeMap.size
        val start = nodeMap[min(k, size - k + 1)]
        val finish = nodeMap[max(k, size - k + 1)]
        if (start == finish) {
            return head
        }
        val (startPrevIndex, startNextIndex) = Pair(min(size - k, k -1), min(k + 1, size - k + 2))
        val (finishPrevIndex, finishNextIndex) = Pair(
            max(size - k, k - 1),
            max(k + 1, size - k + 2)
        )
        val isNeighbour = (size % 2 == 0) && ( k == size / 2 || k == size / 2 + 1)
        val (startPrev, startNext) = Pair(nodeMap[startPrevIndex], nodeMap[startNextIndex])
        val (finishPrev, finishNext) = Pair(nodeMap[finishPrevIndex], nodeMap[finishNextIndex])
        startPrev?.let {
            it.next = finish
        }
        finish?.let {
            if (isNeighbour) {
                it.next = start
            } else {
                it.next = startNext
            }
        }
        finishPrev?.let {
            if (isNeighbour) {
                it.next = finishNext
            } else {
                it.next = start
            }
        }
        start?.let {
            if (!isNeighbour) {
                it.next = finishNext
            }
        }
        return if (k == 1 || k == size) finish else head
    }

    fun nodes(head: ListNode?): Map<Int, ListNode> {
        var node = head
        val nodeMap = mutableMapOf<Int, ListNode>()
        var count = 1
        while (node != null) {
            nodeMap[count++] = node
            node = node.next
        }
        return nodeMap
    }

}