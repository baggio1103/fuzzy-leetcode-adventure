package dailyChallenge.year2026.january.january21

fun main() {
    println(minBitwiseArray(listOf(2, 3, 5, 7)).contentToString())
}

fun minBitwiseArray(nums: List<Int>): IntArray {
    val answer = IntArray(nums.size)
    for ((i, x) in nums.withIndex()) {
        if (x % 2 == 0) {
            answer[i] = -1
        } else {
            val z = x.inv() and (x + 1)
            answer[i] = x - z + (z shr 1)
        }
    }
    return answer
}
