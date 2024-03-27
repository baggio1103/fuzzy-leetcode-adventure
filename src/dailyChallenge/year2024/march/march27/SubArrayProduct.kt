package dailyChallenge.year2024.march.march27


fun numSubarrayProductLessThanK(array: IntArray, k: Int): Int {
    if (k <= 1) return 0
    var product = 1
    var j = 0
    var count = 0
    for (i in array.indices) {
        product *= array[i]
        if (product >= k) {
            while (product >= k) {
                product /= array[j++]
            }
        }
        count += (i - j + 1)
    }
    return count
}

fun main() {
    println(
        numSubarrayProductLessThanK(
            intArrayOf(10, 5, 2, 6),
            100
        )
    )
    println(
        numSubarrayProductLessThanK(
            intArrayOf(1, 2, 3),
            0
        )
    )
    println(
        numSubarrayProductLessThanK(
            intArrayOf(1, 1, 1),
            1
        )
    )
}