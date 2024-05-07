package dailyChallenge.year2024.may.may7

import java.math.BigInteger

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "Node[val: $`val`]"
    }
}

fun doubleIt(head: ListNode?): ListNode? {
    var node = head
    var value = BigInteger.ZERO
    val ten = BigInteger.TEN
    while (node != null) {
        value = ten * value + BigInteger.valueOf(node.`val`.toLong())
        node = node.next
    }
    if (value == BigInteger.ZERO) return ListNode(value.toInt())
    value *= BigInteger.valueOf(2)
    val valuesAsString = value.toString()
    for (i in valuesAsString.lastIndex downTo 0) {
        node = ListNode(valuesAsString[i].digitToInt()).apply { next = node }
    }
    return node
}
