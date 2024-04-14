package slidingwindow

fun longestSubarray(array: IntArray): Int {
    var left = 0
    var right = 0
    var max = 0
    for (value in array) {
        if (value == 0) {
            max = maxOf(max, left + right)
            left = right
            right = 0
            continue
        }
        right++
    }
    max = maxOf(max, left + right)
    if (max == array.size) return max - 1
    return max
}

fun main() {
    println(
        longestSubarray(
            intArrayOf(1, 1, 0, 1)
        )
    )
    println(
        longestSubarray(
            intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)
        )
    )
    println(
        longestSubarray(intArrayOf(1, 1, 1))
    )
}