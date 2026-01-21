package dailyChallenge.year2026.january.january20

fun main() {
    println(minBitwiseArray(listOf(2,3,5,7)).contentToString())
}

fun minBitwiseArray(nums: List<Int>): IntArray {
    val array = IntArray(nums.size) { -1 }
    for ((index, value) in nums.withIndex()) {
        for (i in 1 until value) {
            if (i or (i + 1) == value) {
                array[index]  = i
                break
            }
        }
    }
    return array
}
