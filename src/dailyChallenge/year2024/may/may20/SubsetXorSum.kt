package dailyChallenge.year2024.may.may20

fun subsetXORSum(nums: IntArray): Int {
   var result = 0
    for (value in nums) {
        result = result or value
    }
    return result shl (nums.size - 1)
}

fun main() {
    println(
        subsetXORSum(
            intArrayOf(1, 3)
        )
    )
    println(
        subsetXORSum(
            intArrayOf(5, 1, 6)
        )
    )
}