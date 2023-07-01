package dailyChallenge.may17

import kotlin.math.max

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class MaximumTwinSum {

    fun pairSum(head: ListNode?): Int {
        var node = head
        val mutableMap = mutableMapOf<Int, Int>()
        var count = 0
        while (node != null) {
            count++
            mutableMap[count] = node.`val`
            node = node.next
        }
        var result = 0
        for (i in 1 .. mutableMap.size / 2) {
            result = max(result, mutableMap[i]!! + mutableMap[count]!!)
            count--
        }
        return result
    }

}

fun main() {
    val maximumTwinSum = MaximumTwinSum()
    val nodeOne = ListNode(5).also {
        it.next = ListNode(4).also {
            it.next = ListNode(2)
                .also {
                    it.next = ListNode(1)
                }
        }
    }
    val nodeTwo = ListNode(4).also {
        it.next = ListNode(2).also {
            it.next = ListNode(2)
                .also {
                    it.next = ListNode(3)
                }
        }
    }

    println(
        maximumTwinSum.pairSum(
            nodeOne
        )
    )
    println(
        maximumTwinSum.pairSum(
            nodeTwo
        )
    )

}