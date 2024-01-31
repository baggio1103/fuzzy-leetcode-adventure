package dailyChallenge.year2024.january.january31

import java.util.*

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val warmerTemperatures = IntArray(temperatures.size) { _ -> 0 }
    val stack = Stack<Int>()
    for (i in warmerTemperatures.indices) {
        while (stack.isNotEmpty() && temperatures[stack.peek()] < temperatures[i]) {
            warmerTemperatures[stack.peek()] = i - stack.pop()
        }
        stack.push(i)
    }
    return warmerTemperatures
}

fun main() {
    println(
        dailyTemperatures(
            intArrayOf(
                73, 74, 75, 71, 69, 72, 76, 73
            )
        ).asList()
    )
}