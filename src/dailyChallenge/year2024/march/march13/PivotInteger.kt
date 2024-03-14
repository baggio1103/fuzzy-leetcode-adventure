package dailyChallenge.year2024.march.march13

fun pivotInteger(number: Int): Int {
    val pivot = number / 2
    for (i in pivot..number) {
        val leftSide = ((1 + i) * i) / 2
        val rightSide = ((i + number) * (number - i + 1)) / 2
        if (leftSide == rightSide) return i
    }
    return -1
}

fun main() {
    println(
        pivotInteger(8)
    )
}