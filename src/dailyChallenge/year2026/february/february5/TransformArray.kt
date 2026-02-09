package dailyChallenge.year2026.february.february5

fun main() {
    println(constructTransformedArray(intArrayOf(3, -2, 1, 1)).contentToString())
}

fun constructTransformedArray(nums: IntArray): IntArray {
    val result = IntArray(nums.size)
    val n = nums.size
    for (i in nums.indices) {
        result[i] = nums[((i + nums[i]) % n + n) % n]
    }
    return result
}
