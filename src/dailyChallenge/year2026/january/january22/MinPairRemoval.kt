package dailyChallenge.year2026.january.january22

import java.util.PriorityQueue


fun main() {
    println(minimumPairRemoval(intArrayOf(5, 2, 3, 1))) // Non-decreasing
    println(minimumPairRemoval(intArrayOf(2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1)))
}


data class ListNode(
    var value: Long,
    val left: Int,
    var prev: ListNode? = null,
    var next: ListNode? = null
)

fun minimumPairRemoval(nums: IntArray): Int {
    // PQ with comparator as lambda
    val pq = PriorityQueue<PQItem> { a, b ->
        when {
            a.cost != b.cost -> a.cost.compareTo(b.cost)
            else -> a.first.left - b.first.left
        }
    }
    val merged = BooleanArray(nums.size)
    var decreaseCount = 0
    var count = 0
    val head = ListNode(nums[0].toLong(), 0)
    var current = head
    for (i in 1 until nums.size) {
        val newNode = ListNode(nums[i].toLong(), i)
        current.next = newNode
        newNode.prev = current
        pq.offer(PQItem(current, newNode, current.value + newNode.value))
        if (nums[i - 1] > nums[i]) decreaseCount++
        current = newNode
    }

    while (decreaseCount > 0) {
        val item = pq.poll() ?: break
        val first = item.first
        val second = item.second
        val cost = item.cost

        if (merged[first.left] || merged[second.left] || first.value + second.value != cost) continue

        count++
        if (first.value > second.value) decreaseCount--

        val prevNode = first.prev
        val nextNode = second.next

        first.next = nextNode
        nextNode?.prev = first

        prevNode?.let { prev ->
            when {
                prev.value > first.value && prev.value <= cost -> decreaseCount--
                prev.value <= first.value && prev.value > cost -> decreaseCount++
            }
            pq.offer(PQItem(prev, first, prev.value + cost))
        }

        nextNode?.let { next ->
            when {
                second.value > next.value && cost <= next.value -> decreaseCount--
                second.value <= next.value && cost > next.value -> decreaseCount++
            }
            pq.offer(PQItem(first, next, cost + next.value))
        }

        first.value = cost
        merged[second.left] = true
    }

    return count
}

data class PQItem(val first: ListNode, val second: ListNode, val cost: Long)
