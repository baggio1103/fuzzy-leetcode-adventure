package dailyChallenge.year2025.march.march14

fun main() {
    println(maximumCandies(intArrayOf(5, 8, 6), 3))

    println(maximumCandies(intArrayOf(4, 7, 5), 4)) // 3

    println(maximumCandies(intArrayOf(1, 2, 3, 4, 10), 5)) // 3

    val candies = IntArray(10000) { 1000000 }
    val children: Long = 10000

    println(maximumCandies(candies, children))
}

fun maximumCandies(candies: IntArray, k: Long): Int {
    val overallSum = candies.sumOf { it.toLong() }
    if (overallSum < k) return 0
    var max = overallSum / k
    var min: Long = 1
    while (min < max) {
        val middle = (min + max + 1) / 2
        val count = candies.sumOf { it / middle }
        if (count >= k) {
            min = middle
        } else {
            max = middle - 1
        }
    }
    return min.toInt()
}