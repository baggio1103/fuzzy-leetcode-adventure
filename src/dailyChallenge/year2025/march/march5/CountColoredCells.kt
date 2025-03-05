package dailyChallenge.year2025.march.march5

fun main() {
    println(coloredCells(3))
}

fun coloredCells(n: Int): Long {
    if (n == 1) return 1
    val maxWidth = (2 * n).toLong() - 1
    val width = maxWidth - 2
    val depth = n - 1
    return ((1 + width) * depth) + maxWidth
}