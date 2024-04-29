package dailyChallenge.year2024.april.april12

fun trap(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var leftMax = 0
    var rightMax = 0
    var result = 0
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] > leftMax) {
                leftMax = height[left]
            } else result += leftMax - height[left]
            left++
        } else {
            if (height[right] > rightMax) {
                rightMax = height[right]
            } else
                result += rightMax - height[right]
            right--
        }
    }
    return result
}

fun main() {
    println(
        trap(
            intArrayOf(3, 2, 0, 4)
        )
    )
    println(
        trap(
            intArrayOf(
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
            )
        )
    )
    println(
        trap(
            intArrayOf(
                4, 2, 0, 3, 2, 5
            )
        )
    )
}