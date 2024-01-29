package dailyChallenge.year2024.january.january29

import java.util.Stack

class MyQueue {

    private val stackPush = Stack<Int>()
    private val stackPop = Stack<Int>()
    private var valueToPeek = 0
    fun push(x: Int) {
        if (stackPush.size == 0) {
            valueToPeek = x
        }
        stackPush.push(x)
    }

    fun pop(): Int {
        while (!stackPush.empty()) {
            val pop = stackPush.pop()
            stackPop.push(pop)
        }
        val valueToPop = stackPop.pop()
        if (!stackPop.empty()) {
            valueToPeek = stackPop.peek()
        }
        while (!stackPop.isEmpty()) {
            val pop = stackPop.pop()
            stackPush.push(pop)
        }
        return valueToPop
    }

    fun peek(): Int {
        if (stackPush.isEmpty()) {
            throw IllegalArgumentException()
        }
        return valueToPeek
    }

    fun empty(): Boolean {
        return stackPush.empty()
    }

}

fun main() {
    val queue = MyQueue()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(1231231)
    queue.pop()
    println(
        queue.peek()
    )
}