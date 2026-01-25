package dailyChallenge.year2026.january.january23

import java.util.Stack


fun main() {
    println(minimumPairRemoval(intArrayOf(5, 2, 3, 1))) // Non-decreasing
    println(minimumPairRemoval(intArrayOf(2, 2, -1, 3, -2, 2, 1, 1, 1, 0, -1)))
}

fun minimumPairRemoval(nums: IntArray): Int {
    var count = 0
    val stack = Stack<Int>()
    stack.push(nums[0])
    var i = 1
    while (i < nums.size) {
        var curr = nums[i]
        i++
        if (stack.isEmpty()) {
            i++
            stack.push(curr)
            continue
        }
        while (curr < stack.peek() && i < nums.size) {
            if (i < nums.size - 1) {
                curr += nums[i + 1]
                count++
            }
            i++
        }
        if (curr >= stack.peek()) {
            stack.push(curr)
            continue
        }
        stack.push(curr + stack.peek())
        count++
    }
    return count
}

