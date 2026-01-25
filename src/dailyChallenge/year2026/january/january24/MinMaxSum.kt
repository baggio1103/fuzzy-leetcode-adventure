package dailyChallenge.year2026.january.january24

fun main() {
    println(minPairSum(array = intArrayOf(3, 5, 2, 3)))
    println(minPairSum(array = intArrayOf(3, 5, 4, 2, 4, 6)))
}

fun minPairSum(array: IntArray): Int {
    var max = 0
    array.sort()
    for (i in 0 until array.size / 2) {
        max = maxOf(max, array[i] + array[array.lastIndex - i])
    }
    return max
}
