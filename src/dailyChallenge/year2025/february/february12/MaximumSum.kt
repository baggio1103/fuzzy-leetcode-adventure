package dailyChallenge.year2025.february.february12

fun main() {
    println(
        maximumSum(intArrayOf(18, 43, 36, 13, 7))
    )
    println(
        maximumSum(intArrayOf(10, 12, 19, 14))
    )
    println(
        maximumSumIterative(intArrayOf(10, 12, 19, 14))
    )
}

fun maximumSum(array: IntArray): Int =
    array.fold(mutableMapOf<Int, IntArray>()) { map, value ->
        val sumOfDigits = value.sumOfDigits()
        val values = map.getOrPut(sumOfDigits) { intArrayOf(0, 0) }
        if (values[0] > values[1])
            values[1] = maxOf(value, values[1])
        else values[0] = maxOf(value, values[0])
        map
    }.filter { (_, numbers) -> numbers[0] != 0 && numbers[1] != 0 }
        .maxOfOrNull { (_, numbers) -> numbers[0] + numbers[1] } ?: -1

fun maximumSumIterative(array: IntArray): Int {
    val sumOfDigitsToNumbers = mutableMapOf<Int, IntArray>()
    array.forEach { value ->
        val sumOfDigits = value.sumOfDigits()
        val values = sumOfDigitsToNumbers.getOrPut(sumOfDigits) { intArrayOf(0, 0) }
        if (values[0] > values[1])
            values[1] = maxOf(value, values[1])
        else values[0] = maxOf(value, values[0])
    }
    return sumOfDigitsToNumbers
        .filter { (_, values) -> values[0] != 0 && values[1] != 0 }
        .maxOfOrNull { (_, values) -> values[0] + values[1] } ?: -1
}

fun Int.sumOfDigits(): Int {
    var sum = 0
    var value = this
    while (value > 0) {
        sum += (value % 10)
        value /= 10
    }
    return sum
}