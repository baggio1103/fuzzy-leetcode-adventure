package dailyChallenge.year2024.august.august4

fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
    val mod = 1_000_000_007
    val list = buildList {
        for (i in 0 until n) {
            var sum = nums[i]
            add(sum)
            for (j in i + 1 until n) {
                sum += nums[j]
                sum %= mod
                add(sum)
            }
        }
    }.sorted()
    var sum = 0
    for (i in left - 1 until right) {
        sum += list[i]
        sum %= mod
    }
    return sum
}

// 1, 2, 3, 3, 4, 5, 6, 7, 9, 10
// 1, 2, 3, 3, 4, 5, 6, 7, 9, 10
fun main() {
    println(
        rangeSum(
            intArrayOf(1, 2, 3, 4),
            4,
            1,
            5
        )
    )
}