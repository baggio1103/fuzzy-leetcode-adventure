package dailyChallenge.year2026.february.february6

fun main() {
    println(minRemoval(intArrayOf(2, 1, 5), 2))
    println(minRemoval(intArrayOf(1, 6, 2, 9), 3))
}

fun minRemoval(nums: IntArray, k: Int): Int {
    nums.sort()
    val n = nums.size
    var answer = n
    var right = 0
    for (left in nums.indices) {
        while (right < n && nums[right] <= nums[left].toLong() * k) right++
        answer = minOf(answer, n - (right - left))
    }
    return answer
}
