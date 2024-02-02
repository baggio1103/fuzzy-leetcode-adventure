package dailyChallenge.year2024.february.february2

fun sequentialDigits(low: Int, high: Int): List<Int> {
    val sequentialIntegers = mutableListOf<Int>()
    val lengthOfLowValue = lengthOfValue(low)
    val lengthOfHighValue = lengthOfValue(high)
    var currentLength = lengthOfLowValue
    repeat(lengthOfHighValue - lengthOfLowValue + 1) {
        for ((shift, i) in (1 .. 10 - currentLength).withIndex()) {
            var value = 0
            IntRange(i, currentLength + shift).forEach {
                value = value * 10 + it
            }
            if (value > high) {
                return sequentialIntegers
            }
            if (value in low .. high) {
                sequentialIntegers.add(value)
            }
            if (value == 123456789) {
                return sequentialIntegers
            }
        }
        currentLength++
    }
    return sequentialIntegers
}

fun lengthOfValue(low: Int): Int {
    var value = low
    var count = 0
    while (value != 0) {
        value /= 10
        count++
    }
    return count
}

fun main() {
    println(
        sequentialDigits(
            100, 300
        )
    )
    println(
        sequentialDigits(
            1000, 13000
        )
    )
    println(
        sequentialDigits(10, 1000000000)
    )
    println(
        sequentialDigits(58, 150)
    )
}