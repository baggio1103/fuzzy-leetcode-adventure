package dailyChallenge.year2025.november.november25

fun main() {
    println(smallestRepunitDivByK(3))
    println(smallestRepunitDivByK(2))
}

fun smallestRepunitDivByK(k: Int): Int {
    var remainder = 1
    repeat(k) { count ->
        if (remainder % k == 0) return count + 1
        remainder = ((remainder * 10) + 1) % k
    }
    return -1
}
