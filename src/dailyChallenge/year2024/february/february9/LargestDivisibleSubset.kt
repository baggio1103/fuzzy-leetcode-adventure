package dailyChallenge.year2024.february.february9

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    nums.sort()
    val cache = mutableMapOf<Int, List<Int>>()
    fun recursion(nums: IntArray, index: Int): List<Int> {
        val cached = cache[index]
        if (cached != null) {
            return cached
        }
        if (index >= nums.size) {
            return emptyList()
        }
        val list = mutableListOf(nums[index])
        val subList = IntRange(index + 1, nums.lastIndex).filter {
            nums[it] % nums[index] == 0
        }.map {
            recursion(nums, it)
        }.maxByOrNull { it.size } ?: emptyList()
        val result = list + subList
        cache[index] = result
        return result
    }
    return IntRange(0, nums.lastIndex).map {
        recursion(nums, it)
    }.maxBy { it.size }

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