package dailyChallenge.year2025.january.january3

fun main() {
    println(
        waysToSplitArray(nums = intArrayOf(10, 4, -8, 7))
    )
    println(
        waysToSplitArray(nums = intArrayOf(2, 3, 1, 0))
    )
    println(
        waysToSplitArray(nums = intArrayOf(6, -1, 9))
    )
}

fun waysToSplitArray(nums: IntArray): Int {
    val sumArray = LongArray(nums.size)
    sumArray[0] = nums[0].toLong()
    for (i in 1 until nums.size) {
        sumArray[i] = nums[i] + sumArray[i - 1]
    }
    var count = 0
    val overallSum = sumArray.last()
    for (i in 0 until nums.lastIndex) {
        if (sumArray[i] >= overallSum - sumArray[i]) count++
    }
    return count
}
