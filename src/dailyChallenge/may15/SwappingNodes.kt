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
        println("-=-=-=-=-=-=-=-=-=")
        nodeMap.forEach { (_, value) ->
            print("${value.`val`} ")
        }
        println("/ K = $k \n-=-=-=-=-=-=-=-=-=")
        if (start == finish) {
            return head
        }
        if (size == 2) {
            start?.next = null
            finish?.next = start
            return finish
        }
        val (startPrevIndex, startNextIndex) = Pair(min(size - k, k -1), min(k + 1, size - k + 2))

        val (finishPrevIndex, finishNextIndex) = Pair(
            max(size - k, k - 1),
            max(k + 1, size - k + 2)
        )
        val isNeighbour = k == size - k
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
            it.next = finishNext
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

fun main() {
    val swappingNodes = SwappingNodes()

    printInfo(
        swappingNodes.swapNodes(ListNode(10).also {
            it.next = ListNode(25).also {
                it.next = ListNode(35)
            }
        }, 2)
    )
    printInfo(
        swappingNodes.swapNodes(
            ListNode(7).also {

                it.next = ListNode(9)
                    .also {
                        it.next = ListNode(6).also {
                            it.next = ListNode(6).also {
                                it.next = ListNode(7).also {
                                    it.next = ListNode(8).also {
                                        it.next = ListNode(3)
                                            .also {
                                                it.next = ListNode(0).also {
                                                    it.next = ListNode(9).also {
                                                        it.next = ListNode(5)
                                                    }
                                                }
                                            }
                                    }
                                }
                            }
                        }
                    }
            }, 5
        )
    )

    printInfo(
        swappingNodes.swapNodes(ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(5)
                    }
                }
            }
        }, 1)
    )
    println("-=-=-=-=-=-=-=-=-=")
    printInfo(
        swappingNodes.swapNodes(
            ListNode(1).also {
                it.next = ListNode(2).also {
                    it.next = ListNode(3).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(5)
                        }
                    }
                }
            }, 5
        )
    )

    println("-=-=-=-=-=-=-=-=-=")
    printInfo(swappingNodes.swapNodes(ListNode(10), 1))

    println("-=-=-=-=-=-=-=-=-=")
    printInfo(
        swappingNodes.swapNodes(ListNode(10).also {
            it.next = ListNode(25)
        }, 1)
    )

    println("-=-=-=-=-=-=-=-=-=")
    printInfo(swappingNodes.swapNodes(ListNode(1).also {
        it.next = ListNode(2).also {
            it.next = ListNode(3).also {
                it.next = ListNode(4).also {
                    it.next = ListNode(5)
                }
            }
        }
    }, 2))

    println("-=-=-=-=-=-=-=-=-=")
    printInfo(swappingNodes.swapNodes(ListNode(1).also {
        it.next = ListNode(2).also {
            it.next = ListNode(3).also {
                it.next = ListNode(4).also {
                    it.next = ListNode(5)
                }
            }
        }
    }, 3))
//
//    printInfo(
//        swappingNodes.swapNodes(ListNode(1), 1)
//    )
//
//    println("-=-=-=-=-=-=-=-=-=")
//
//    printInfo(
//        swappingNodes.swapNodes(ListNode(1).also {
//            it.next = ListNode(2).also {
//                it.next = ListNode(3)
//            }
//        }, 1)
//    )
}

fun printInfo(node: ListNode?) {
    var currentNode = node
    while (currentNode != null) {
        println(currentNode.`val`)
        currentNode = currentNode.next
    }
}

