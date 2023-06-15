package designProblems.stack

import java.util.*

class MaxStack<T: Comparable<T>> : Stack<T>() {

    private val stack = Stack<T>()

    private val maxStack = Stack<T>()

    override fun push(item: T): T {
        if (stack.isEmpty()) {
            stack.push(item)
            maxStack.push(item)
            return item
        }
        val currentMax = maxStack.peek()
        if (item > currentMax) {
            maxStack.push(item)
        }
        stack.push(item)
        return item
    }

    override fun pop(): T {
        val item = stack.pop()
        if (item == maxStack.peek()) {
            maxStack.pop()
        }
        return item
    }

    override fun peek(): T {
        return stack.peek()
    }

    fun max(): T {
        return maxStack.peek()
    }

    override val size: Int
        get() = stack.size

}
