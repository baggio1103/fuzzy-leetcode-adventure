package dailyChallenge.year2024.may.may21

fun subsets(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    result.add(emptyList())
    fun recursive(index: Int, acc: MutableList<Int>) {
        if (index >= nums.size) return
        acc.add(nums[index])
        result.add(acc)
        (index + 1 until  nums.size).forEach {
            recursive(it, acc.toMutableList())
        }
    }
    nums.indices.forEach {
        recursive(it, mutableListOf())
    }
    return result
}

fun main() {
    println(
        subsets(
            intArrayOf(1, 2, 3)
        )
    )
}