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
    if (numbers.size == 1 && numbers[0] % 3 != 0) return 0
    numbers.sort()
    val overallSum = numbers.sum()
    return when (overallSum % 3) {
        1 -> {
            // a % 3 == 1    // 1, 4, 7
            // a + b % 3 = 1 // (2 + 2, 2 + 8)
            maxOf(
                overallSum - numbers.singleRemainderOne(1),

                overallSum - numbers.twoRemainderOne(2)
            )
        }

        2 -> {
            // a % 3 == 2 // {14} - {1, 4}
            // a + b % 3 == 2, // 1 + 4
            maxOf(
                overallSum - numbers.singleRemainderOne(2),
                overallSum - numbers.twoRemainderOne(1),
            )
        }

        else -> overallSum
    }
}

fun IntArray.singleRemainderOne(div: Int): Int = firstOrNull { it % 3 == div } ?: Int.MAX_VALUE

fun IntArray.twoRemainderOne(div: Int): Int {
    var index = -1
    var left = Int.MIN_VALUE
    for ((i, number) in withIndex()) {
        if (number % 3 == div) {
            index = i
            left = number
            break
        }
    }
    var right = Int.MIN_VALUE
    for ((i, number) in withIndex()) {
        if (number % 3 == div && i != index) {
            right = number
            break
        }
    }
    return if (left == Int.MIN_VALUE || right == Int.MIN_VALUE) Int.MAX_VALUE else left + right
}
