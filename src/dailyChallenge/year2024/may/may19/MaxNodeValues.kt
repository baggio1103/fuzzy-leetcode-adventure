package dailyChallenge.year2024.may.may19

fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    var nodeSum = 0L
    val netChange = IntArray(nums.size) {
        nodeSum += nums[it]
        (nums[it] xor k) - nums[it]
    }
    netChange.sortDescending()
    for (i in nums.indices step 2) {
        if (i + 1 == nums.size) break
        val pairSum = netChange[i] + netChange[i + 1]
        if (pairSum > 0) nodeSum += pairSum
    }
    return nodeSum
}

fun main() {
    println(
        maximumValueSum(
            intArrayOf(1, 2, 1),
            3,
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(0, 2)
            )
        )
    )
    println(
        maximumValueSum(
            intArrayOf(2, 3),
            7,
            arrayOf(
                intArrayOf(0, 1)
            )
        )
    )
}