package dailyChallenge.year2024.march.march16

fun findMaxLength(nums: IntArray): Int {
    var maxLength = 0
    var count = 0
    val map = mutableMapOf<Int, Int>()
    map[0] = -1
    for (i in nums.indices) {
        count += if (nums[i] == 1) 1 else -1
        if (map[count] != null) {
            maxLength = maxOf(maxLength, i - (map[count] ?: 0))
        } else
            map[count] = i
    }
    return maxLength
}

fun main() {
    println(
        findMaxLength(
            intArrayOf(0, 1, 1)
        )
    )
    println(
        findMaxLength(
            intArrayOf(0, 0, 0, 0,)
        )
    )
    println(
        findMaxLength(
            intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1)
        )
    )
    println(
        findMaxLength(
            intArrayOf(0, 0, 1, 1, 0, 0)
        )
    )
    println(
        findMaxLength(
            intArrayOf(0, 0, 0, 0, 1)
        )
    )
}