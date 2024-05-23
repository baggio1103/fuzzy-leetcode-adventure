package dailyChallenge.year2024.may.may23

fun beautifulSubsets(nums: IntArray, k: Int): Int {
    return countSubsets(nums.sortedArray(), k, mutableMapOf(), 0) - 1
}

private fun countSubsets(nums: IntArray, difference: Int, freqMap: MutableMap<Int, Int>, i: Int): Int {
    if (i == nums.size) {
        return 1
    }
    // Count subsets where nums[i] is not taken
    var totalCount = countSubsets(nums, difference, freqMap, i + 1)
    if (!freqMap.containsKey(nums[i] - difference)) {
        freqMap[nums[i]] = freqMap.getOrDefault(nums[i], 0) + 1

        totalCount += countSubsets(nums, difference, freqMap, i + 1)
        freqMap[nums[i]] = freqMap[nums[i]]!! -
                1
        if (freqMap[nums[i]] == 0) {
            freqMap.remove(nums[i])
        }
    }
    return totalCount
}

fun main() {
    println(
        beautifulSubsets(
            intArrayOf(4, 2, 5, 9, 10, 3), 1
        )
    )
}