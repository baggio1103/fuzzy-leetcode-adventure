package dailyChallenge.year2026.january.january2

fun main() {
    println(repeatedNTimes(intArrayOf(1, 2, 3, 3)))
    println(repeatedNTimes(intArrayOf(2, 1, 2, 5, 3, 2)))
}

fun repeatedNTimes(numbers: IntArray): Int {
    val n = numbers.size / 2
    val countMap = mutableMapOf<Int, Int>()
    numbers.forEach { number ->
        val count = countMap.getOrDefault(number, 0) + 1
        if (count == n) return number
        countMap[number] = count
    }
    return -1
}
