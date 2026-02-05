package bytebytego.prefixsum

fun main() {
    println(
        subarraySum(intArrayOf(1, 2, -1, 1, 2), 3)
    )
    println(
        subarraySumCount(intArrayOf(1, 2, -1, 1, 2), 3)
    )
}

fun subarraySum(nums: IntArray, k: Int): Int {
    val prefixSum = IntArray(nums.size + 1)
    for (i in nums.indices) {
        prefixSum[i + 1] = prefixSum[i] + nums[i]
    }
    var count = 0
    for (i in nums.indices) {
        for (j in i + 1..nums.size) {
            if (prefixSum[j] - prefixSum[i] == k)
                count++
        }
    }
    return count
}

fun subarraySumCount(nums: IntArray, k: Int): Int {
    var currPrefixSum = 0
    val prefixSumMap = mutableMapOf(0 to 1) // sum to frequency
    var count = 0
    nums.forEach { number ->
        currPrefixSum += number
        val diff = prefixSumMap[currPrefixSum - k]
        if (diff != null) count += diff
        prefixSumMap[currPrefixSum] = prefixSumMap.getOrDefault(currPrefixSum, 0) + 1
    }
    return count
}
