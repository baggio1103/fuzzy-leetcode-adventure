package dailyChallenge.year2024.march.march14

fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
    var count = 0
    for (i in nums.indices) {
        for (j in 0 until nums.size - i) {
            var sum = 0
            for (y in j..j + i) {
                if (nums[y] == 1) sum++
            }
            if (sum == goal) count++
        }
    }
    return count
}

fun main() {
    println(
        numSubarraysWithSum(
            intArrayOf(1, 0, 1, 0, 1), 2
        )
    )
    println(
        numSubarraysWithSum(
            intArrayOf(0, 0, 0, 0, 0), 0
        )
    )
}