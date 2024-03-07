package dailyChallenge.year2024.march.march7

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun middleNode(head: ListNode?): ListNode? {
    val middle = (size(head) / 2) + 1
    var count = 1
    var node = head
    while (node != null) {
        if (count == middle) {
            return node
        }
        node = node.next
        count++
    }
    return null
}

fun size(head: ListNode?): Int {
    var count = 0
    var node = head
    while (node != null) {
        node = node.next
        count++
    }
    return count
}

fun main() {

}