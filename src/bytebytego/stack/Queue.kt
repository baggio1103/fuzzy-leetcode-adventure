package bytebytego.stack

import java.util.Stack

fun main() {
    val queue = Queue()
    queue.push(1)
    queue.push(2)
    require(1 == queue.peek()) { "queue top must be 1" }
    require(1 == queue.pop()) { "queue top must be 2" }
    val queueOne = Queue()
    queueOne.push(1)
    require(queueOne.pop() == 1)
    require(queueOne.empty()) { "Queue must be empty" }
}

class Queue {

    private val enqueueStack = Stack<Int>()
    private val dequeStack = Stack<Int>()


    fun push(x: Int) {
        enqueueStack.push(x)
    }

    fun pop(): Int {
        if (dequeStack.isNotEmpty()) {
            return dequeStack.pop()
        }
        while (enqueueStack.isNotEmpty()) {
            dequeStack.push(enqueueStack.pop())
        }
        return dequeStack.pop()
    }

    fun peek(): Int {
        if (dequeStack.isNotEmpty()) {
            return dequeStack.peek()
        }
        while (enqueueStack.isNotEmpty()) {
            dequeStack.push(enqueueStack.pop())
        }
        return dequeStack.peek()
    }

    fun empty(): Boolean = dequeStack.isEmpty() && enqueueStack.isEmpty()

}
