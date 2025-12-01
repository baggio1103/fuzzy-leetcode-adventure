package dailyChallenge.year2025.november.november30

fun main() {
    println(minSubarray(intArrayOf(3, 1, 4, 2), 6)) // 1
    println(minSubarray(intArrayOf(6, 3, 5, 2), 9)) // 2
    println(minSubarray(intArrayOf(1000000000, 1000000000, 1000000000), 3)) // 0
}

fun minSubarray(numbers: IntArray, p: Int): Int {
    val total = numbers.fold(0L) { acc, value -> acc + value }
    val target = total % p
    if (target == 0L) return 0
    val modMap = mutableMapOf<Long, Int>()
    modMap[0] = -1
    var result = numbers.size
    var prefix = 0L
    for ((index, number) in numbers.withIndex()) {
        prefix = (prefix + number) % p
        val value = (prefix - target + p) % p
        if (value in modMap) result = minOf(result, index - modMap.getValue(value))
        modMap[prefix] = index
    }
    return if (result == numbers.size) -1 else result
}

