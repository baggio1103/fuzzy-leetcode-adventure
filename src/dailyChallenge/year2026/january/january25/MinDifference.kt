package dailyChallenge.year2026.january.january25

fun main() {
    println(minimumDifference(intArrayOf(9, 4, 1, 7), 2))
}

fun minimumDifference(array: IntArray, k: Int): Int {
    array.sort()
    var result = Int.MAX_VALUE
    var i = 0
    while (i + k - 1 < array.size) {
        result = minOf(result, array[i + k - 1] - array[i])
        i++
    }
    return result
}

