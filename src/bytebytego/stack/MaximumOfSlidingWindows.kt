package bytebytego.stack

import java.util.ArrayDeque

fun main() {
    println(maximumOfSlidingWindows(intArrayOf(3, 2, 4, 1, 2, 1, 1), 4))
}

fun maximumOfSlidingWindows(array: IntArray, k: Int): List<Int> {
    val result = mutableListOf<Int>()
    val deque = ArrayDeque<Pair<Int, Int>>()
    var left = 0
    var right = 0
    while (right < array.size) {
        val value = array[right]
        while (deque.isNotEmpty() && deque.peekFirst().first <= value)
            deque.poll()
        deque.push(value to right)
        if (right - left + 1 == k) {
            val (windowMax, index) = deque.peekLast()
            if (index > left)
                deque.pollLast()
            result.add(windowMax)
            left++
        }
        right++
    }
    return result
}

