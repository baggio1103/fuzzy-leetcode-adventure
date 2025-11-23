package dailyChallenge.year2025.november.november22

fun main() {
    println(minimumOperations(intArrayOf(1, 2, 3, 4)))
}

fun minimumOperations(numbers: IntArray): Int = numbers.sumOf { number ->
    (if (number % 3 == 0) 0 else 1) as Int
}
