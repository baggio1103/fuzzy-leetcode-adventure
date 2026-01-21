package bytebytego.linkedlist

fun main() {
    val cache = LRUCache(3)
    cache[1] = 100
    println(cache[1])
    cache[2] = 250
    cache[4] = 300
    cache[3] = 200
    println(cache[4])
    println(cache[1])
}

class LRUCache(capacity: Int) {

  private  val cacheCapacity = capacity

    private val map = mutableMapOf<Int, ListNode>()
    private var head: ListNode? = null // LRU
    private var tail: ListNode? = null // MRU

    operator fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToTail(node)
        return node.value
    }

    operator fun set(key: Int, value: Int) {
        val node = map[key]
        if (node != null) {
            node.value = value
            moveToTail(node)
        } else {
            if (map.size >= cacheCapacity) removeHead()
            val listNode = ListNode(key, value)
            addNode(listNode)
        }
    }

    private fun addNode(node: ListNode) {
        node.prev = tail
        node.next = null
        tail?.next = node
        tail = node
        if (head == null) head = node
        map[node.key] = node
    }

    private fun moveToTail(node: ListNode) {
        if (node == tail) return
        // Remove node from its current position
        node.prev?.next = node.next
        node.next?.prev = node.prev
        if (node == head) head = node.next
        // Add to tail
        node.prev = tail
        node.next = null
        tail?.next = node
        tail = node
    }

    private fun removeHead() {
        map.remove(head?.key)
        head = head?.next
        head?.prev = null
        if (head == null) tail = null
    }

    private class ListNode(val key: Int, var value: Int) {
        var prev: ListNode? = null
        var next: ListNode? = null
    }
}
