package dailyChallenge.year2024.february.february9.iterative

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    nums.sort()
    val dp = Array(nums.size) { index ->
        listOf(nums[index])
    }
    for (i in nums.lastIndex - 1 downTo 0) {
        val subList = IntRange(i + 1, nums.lastIndex).filter {
            nums[it] % nums[i] == 0
        }.map { dp[it] }.maxByOrNull { it.size } ?: emptyList()
        dp[i] = dp[i] + subList
    }
    return dp.maxBy { it.size }
}

fun main() {
    println(
        largestDivisibleSubset(
            intArrayOf(1, 2, 3, 9)
        )
    )
    println(
        largestDivisibleSubset(
            intArrayOf(2, 3, 9, 18, 27)
        )
    )
    println(
        largestDivisibleSubset(
            intArrayOf(3, 4, 16, 8)
        )
    )
}