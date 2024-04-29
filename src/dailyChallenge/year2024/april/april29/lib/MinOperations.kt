package dailyChallenge.year2024.april.april29.lib

fun minOperations(nums: IntArray, k: Int): Int {
    val reduce = nums.reduce { a, b -> a xor b }
    return Integer.bitCount(reduce xor k)
}

fun main() {
    println(
        minOperations(
            intArrayOf(2, 1, 3, 4),
            1
        )
    )
}