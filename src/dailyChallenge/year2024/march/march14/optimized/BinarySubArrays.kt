package dailyChallenge.year2024.march.march14.optimized

fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    fun count(goal: Int): Int {
        if (goal < 0) return 0
        var count = 0
        var sum = 0
        var left = 0
        for (r in nums.indices) {
            sum += nums[r]
            while (sum > goal) {
                sum -= nums[left]
                left++
            }
            count += (r - left + 1)
        }
        return count
    }
    return count(goal) - count(goal - 1)
}

fun main() {
    println(
        numSubarraysWithSum(
            intArrayOf(1, 0, 1, 0, 1),
            2
        )
    )
    println(
        numSubarraysWithSum(
            intArrayOf(0, 0, 0, 0, 0),
            0
        )
    )
}