package dailyChallenge.year2025.february.february9

fun main() {
    println(
        countBadPairs(array =  intArrayOf(4, 1, 3, 3))
    )
}

fun countBadPairs(array: IntArray): Long {
    var badPairs = 0L
    val map = mutableMapOf<Int, Int>()
    for ((index, value) in array.withIndex()) {
        val difference = index - value
        val goodParsCount = map[difference] ?: 0
        badPairs += index - goodParsCount
        map[difference] = goodParsCount + 1
    }
    return badPairs
}