package designProblems.stack

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaxStackTest {

    @Test
    fun testOne() {
        val maxStack = MaxStack<Int>()
        maxStack.push(2)
        maxStack.push(1)
        assertEquals(2, maxStack.max())
        assertEquals(1, maxStack.pop())
        assertEquals(2, maxStack.max())
    }

    @Test
    fun testTwo() {
        val maxStack = MaxStack<Int>()
        maxStack.push(1)
        maxStack.push(2)
        assertEquals(2, maxStack.max())
        assertEquals(2, maxStack.pop())
        assertEquals(1, maxStack.max())

    }

    @Test
    fun testThree() {
        val maxStack = MaxStack<Int>()
        maxStack.push(2)
        maxStack.push(3)
        maxStack.push(9)
        maxStack.push(7)
        maxStack.push(2)
        assertEquals(9, maxStack.max())
        assertEquals(9, maxStack.max())
        assertEquals(9, maxStack.max())
        assertEquals(2, maxStack.pop())
        assertEquals(9, maxStack.max())
    }

}