package dailyChallenge.year2024.january.january16

import kotlin.random.Random


class Node(val value: Int) {
    var prevValue: Node? = null
    var nextValue: Node? = null

    override fun toString(): String {
        return "Node[val: $value, prev: ${prevValue?.value} next: ${nextValue?.value}]"
    }
}

class LinkedListRandomizedSet {
    // Used to access any value for  O (1) while deleting
    private val randomMap = mutableMapOf<Int, Node>()

    // Used for tracking to distribute values evenly while getRandom()
    private var head: Node? = null
    private var tail: Node? = null
    private var currentNode: Node? = null

    fun insert(`val`: Int): Boolean {
        // Value is already present
        if (randomMap[`val`] != null) {
            return false
        }
        val node = Node(`val`)
        randomMap[`val`] = node
        val (head, tail) = Pair(head, tail)
        if (tail == null || head == null) {
            this.head = node
            this.tail = node
            return true
        }
        //
        val value = tail.value
        val prevNode = randomMap[value] ?: throw IllegalArgumentException()
        prevNode.nextValue = node
        node.prevValue = prevNode
        this.tail = node
        return true
    }

    fun remove(`val`: Int): Boolean {
        val node = randomMap[`val`] ?: return false
        if (node == tail) {
            tail = tail?.prevValue
            tail?.nextValue = null
        }
        if (node == head) {
            head = head?.nextValue
            head?.prevValue = null
        }
        if (node.value == currentNode?.value) {
            currentNode = currentNode?.nextValue
        }
        node.prevValue?.nextValue = node.nextValue
        node.nextValue?.prevValue = node.prevValue
        randomMap.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        val random = Random.nextInt(1, 25) % randomMap.size
        repeat(random) {
            currentNode = currentNode?.nextValue
        }
        if (currentNode == null) {
            currentNode = head?.nextValue
            return head?.value ?: 0
        }
        val value = currentNode?.value ?: 0
        currentNode = currentNode?.nextValue
        return value
    }

}

fun main() {
    val randomizedSet = LinkedListRandomizedSet()
    println(
        randomizedSet.insert(1)
    )
    println(
        randomizedSet.insert(2)
    )
    println(
        randomizedSet.insert(3)
    )
    println(
        randomizedSet.remove(2)
    )
    println(randomizedSet.remove(1))
    println(
        randomizedSet.getRandom()
    )
}