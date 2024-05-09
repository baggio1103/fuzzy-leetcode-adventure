package dailyChallenge.year2024.may.may9

// Sorting
fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
    happiness.sortDescending()
    var happinessSum = 0L
    repeat(k) { i ->
        happiness[i] -= i
        happinessSum += if (happiness[i] < 0) 0 else happiness[i]
    }
    return happinessSum
}

fun main() {
    println(
        maximumHappinessSum(
            happiness = intArrayOf(1, 2, 3),
            2
        )
    )
    println(
        maximumHappinessSum(
            intArrayOf(1, 1, 1, 1), 1
        ),
    )
    println(
        maximumHappinessSum(
            intArrayOf(2, 3, 4, 5),
            1
        )
    )
}