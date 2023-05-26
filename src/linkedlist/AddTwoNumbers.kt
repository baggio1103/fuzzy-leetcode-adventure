package linkedlist

class AddTwoNumbers {

    fun addTwoNumbers(headOne: ListNode?, headTwo: ListNode?): ListNode? {
        var nodeOne = headOne
        var nodeTwo = headTwo
        var newHead: ListNode? = null
        var nodeNext: ListNode? = null
        var additional = 0
        while (!(nodeOne == null && nodeTwo == null)) {
            val value = (nodeTwo?.`val` ?: 0) + (nodeOne?.`val` ?: 0) + additional
            val (add, remainder) = if (value >= 10) {
                Pair(1, value % 10)
            } else {
                Pair(0, value)
            }
            additional = add
            val node = ListNode(remainder)
            if (newHead == null) {
                newHead = node
                nodeNext = node
            } else {
                nodeNext?.next = node
                nodeNext = nodeNext?.next
            }
            nodeOne = nodeOne?.next
            nodeTwo = nodeTwo?.next
        }
        if (additional == 1) {
            nodeNext?.next = ListNode(1)
        }
        return newHead
    }

}

fun main() {
    val list = AddTwoNumbers()
    val headOne = ListNode(2).also { head ->
        head.next = ListNode(4).also {
            it.next = ListNode(3)
        }
    }
    val headTwo = ListNode(5).also { head ->
        head.next = ListNode(6).also {
            it.next = ListNode(4).also {
                it.next = ListNode(111)
            }
        }
    }

    list.addTwoNumbers(headOne, headTwo)?.info()

    list.addTwoNumbers(
        ListNode(0),
        ListNode(0)
    )?.info()

    list.addTwoNumbers(
        ListNode(9).also { it.next = ListNode(9) },
        ListNode(1)
    )?.info()

    list.addTwoNumbers(
        ListNode(1).also { it.next = ListNode(2).also { it.next = ListNode(5) } },
        ListNode(1).also { it.next = ListNode(2) }
    )?.info()

}