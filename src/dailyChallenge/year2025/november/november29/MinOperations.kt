package dailyChallenge.year2025.november.november29

fun main() {
    println(
        minOperations(intArrayOf(3, 9, 7), 5)
    )
    println(
        minOperations(intArrayOf(4, 1, 3), 4)
    )
    println(
        minOperations(intArrayOf(3, 2), 6)
    )
    println(
        minOperations(intArrayOf(9, 5), 14)
    )
}

fun minOperations(numbers: IntArray, k: Int): Int = numbers.sum() % k
