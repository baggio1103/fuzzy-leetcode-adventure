package dailyChallenge.year2025.february.february15

fun main() {
    println(punishmentNumber(10))
    println(punishmentNumber(37))
}

fun punishmentNumber(number: Int): Int {
    return (1..number).reduce { acc, currentNumber ->
        val squaredNumber = currentNumber * currentNumber
        if (canPartition(squaredNumber, currentNumber)) {
            acc + squaredNumber
        } else acc
    }
}

fun canPartition(number: Int, target: Int): Boolean = when {
    number < target || target < 0 -> false
    number == target -> true
    else -> canPartition(number / 10, target - (number % 10))
            || canPartition(number / 100, target - (number % 100))
            || canPartition(number / 1000, target - (number % 1000))
}