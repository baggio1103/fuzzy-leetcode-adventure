package dailyChallenge.year2025.november.november27

fun main() {
    println(
        maxSubarraySum(intArrayOf(-5, 1, 2, -3, 4), 2)
    )
    println(
        maxSubarraySum(intArrayOf(-1, -2, -3, -4, -5), 4)
    )
    println(
        maxSubarraySum(intArrayOf(-1, -2, -3, -4, -5), 4)
    )
    println(
        maxSubarraySum(intArrayOf(1, -2, 3, 4), 2)
    )
}

fun maxSubarraySum(nums: IntArray, k: Int): Long {
    val minPrefix = LongArray(k) { Long.MAX_VALUE / 4 }
    var prefixSum = 0L
    var max = Long.MIN_VALUE
    for ((index, number) in nums.withIndex()) {
        prefixSum += number
        val mod = (index + 1) % k
        max = maxOf(max, prefixSum - minPrefix[mod])
        minPrefix[mod] = minOf(minPrefix[mod], prefixSum)
    }
    return max
}
