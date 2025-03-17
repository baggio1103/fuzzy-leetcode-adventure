package dailyChallenge.year2025.march.march12

fun main() {
    println(maximumCount(intArrayOf(1, 2, 3, 4, 5)))
}

fun maximumCount(nums: IntArray): Int = maxOf(
    nums.count { it > 0 }, nums.count { it < 0 }
)