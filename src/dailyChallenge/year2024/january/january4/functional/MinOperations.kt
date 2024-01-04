package dailyChallenge.year2024.january.january4.functional

fun minOperations(numbers: IntArray): Int {
    return numbers.asList().groupingBy { it }.eachCount().values
        .sumOf { occurrence ->
            if (occurrence < 2) {
                return -1
            }
            val (div, remainder) = Pair(occurrence / 3, occurrence % 3)
            if (remainder == 0) {
                div
            } else
                div + 1
        }
}

fun main() {
    println(
        minOperations(
            intArrayOf(2, 3, 3, 2, 2, 4, 2, 3, 4)
        )
    )
    println(
        minOperations(
            intArrayOf(2, 1, 2, 2, 3, 3)
        )
    )
}