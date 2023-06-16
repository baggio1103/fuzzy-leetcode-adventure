package designProblems.stack

import java.util.Stack

class MinStack {

    private val stack = Stack<Int>()

    private val minStack = Stack<Int>()

    fun push(`val`: Int) {
        if (stack.isEmpty()) {
            stack.push(`val`)
            minStack.push(`val`)
            return
        }
        if (`val` <= minStack.peek()) {
            minStack.push(`val`)
        }
        stack.push(`val`)
    }

    fun pop() {
        val `val` = stack.pop()
        if (`val` == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}

fun main() {
    val stack = MinStack()
    stack.push(0)
    stack.push(1)
    stack.push(0)
    println(
        stack.getMin()
    )
    stack.pop()
    println(stack.getMin())
}
