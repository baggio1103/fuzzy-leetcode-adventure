package dailyChallenge.year2025.november.november23


fun main() {
    println(
        maxSumDivThree(intArrayOf(3, 6, 5, 1, 8)) // 18
    )
    println(
        maxSumDivThree(intArrayOf(4)) // 0
    )
    println(
        maxSumDivThree(intArrayOf(1, 2, 3, 4, 4)) // 12
    )
    println(
        maxSumDivThree(intArrayOf(2, 6, 2, 2, 7)) // 15
    )
    println(
        maxSumDivThree(intArrayOf(5, 2, 2, 2))
    )
    println(
        maxSumDivThree(intArrayOf(3, 1, 2))
    )
}

fun maxSumDivThree(numbers: IntArray): Int {
    var smallestNumberOne = 1_000_000
    var smallestNumberTwo = 1_000_000
    var sum = 0
    for (number in numbers) {
        if (number % 3 == 1) {
            smallestNumberTwo = minOf(smallestNumberTwo, smallestNumberOne + number)
            smallestNumberOne = minOf(smallestNumberOne, number)
        }
        if (number % 3 == 2) {
            smallestNumberOne = minOf(smallestNumberOne, smallestNumberTwo + number)
            smallestNumberTwo = minOf(smallestNumberTwo, number)
        }
        sum += number
    }
    return when (sum % 3) {
        1 -> sum - smallestNumberOne
        2 -> sum - smallestNumberTwo
        else -> sum
    }
}

