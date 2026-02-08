package dailyChallenge.year2026.february.february1

fun minimumCost(nums: IntArray): Int {
    var b = nums[1]
    var c = nums[2]
    for (i in 3 until nums.size) {
        // nums[i] < b or c
        if (nums[i] < c) {
            b = minOf(b, c)
            c = nums[i]
        } else if (nums[i] < b) {
            c = minOf(b, c)
            b = nums[i]
        }
    }
    return nums[0] + b + c
}

