package dailyChallenge.year2025.november.november19

fun main() {
    println(findFinalValue(intArrayOf(5, 3, 6, 1, 12), 3))
    println(findFinalValue(intArrayOf(2, 7, 9), 4))
}

fun findFinalValue(nums: IntArray, original: Int): Int {
    var result = original
    var i = 0
    while (i < nums.size) {
        if (nums[i] == result) {
            result *= 2
            i = 0
        } else
            i++
    }
    return result
}
