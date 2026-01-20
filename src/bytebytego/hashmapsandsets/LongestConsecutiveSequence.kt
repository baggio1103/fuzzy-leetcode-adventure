package bytebytego.hashmapsandsets

import kotlin.math.max

fun main() {
    println(longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    println(longestConsecutive(intArrayOf(1, 6, 2, 5, 8, 7, 10, 3)))
}

fun longestConsecutive(numbers: IntArray): Int {
    var longestSequence = 0
    val set = numbers.toSet()
    for (number in numbers) {
        if (number - 1 !in set) {
            var currentNumber = number
            var currentSequence = 1
            while (currentNumber + 1 in set) {
                currentSequence++
                currentNumber++
            }
            longestSequence = max(currentSequence, longestSequence)
        }
    }
    return longestSequence
}
