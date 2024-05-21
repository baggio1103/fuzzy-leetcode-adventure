package dailyChallenge.year2024.may.may21

fun subsets(nums: IntArray): List<List<Int>> {

    fun recursive(index: Int, acc: MutableList<Int>) {
        if (index >= nums.size) return
        acc.add(nums[index])
        println(acc)
        (index + 1 until  nums.size).forEach {
            recursive(it, acc.toMutableList())
        }
    }
    nums.indices.forEach {
        recursive(it, mutableListOf())
    }
    return emptyList()
}

fun main() {
    println(
        subsets(
            intArrayOf(1, 2, 3)
        )
    )
}