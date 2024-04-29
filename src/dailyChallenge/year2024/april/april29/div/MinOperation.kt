package dailyChallenge.year2024.april.april29.div

fun minOperations(nums: IntArray, k: Int): Int {
    var reduce = nums.reduce { a, b -> a xor b }
    var result = k
    var count = 0
    while (reduce > 0 || result > 0) {
        if (reduce % 2 != k % 2) count++
        result /= 2
        reduce /= 2
    }
    return count
}

fun main() {
    println(
        minOperations(
            intArrayOf(2, 1, 3, 4),
            1
        )
    )
}