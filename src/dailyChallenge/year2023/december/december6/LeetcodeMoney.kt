package dailyChallenge.december.december6

fun totalMoney(n: Int): Int {
    val divider = n / 7
    val remainder = n % 7
    return (if (divider >= 1) {
        ((28 + 28 + 7 * (divider - 1)) * divider) / 2
    } else 0) +
    ((2 * divider + remainder + 1) * remainder) / 2
}

fun main() {
    println(
        totalMoney(4)
    )
    println(
        totalMoney(10)
    )
    println(
        totalMoney(20)
    )
}