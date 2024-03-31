package dailyChallenge.year2024.march.march31

fun countSubArrays(array: IntArray, minK: Int, maxK: Int): Long {
    var count = 0L
    var minKIndex = -1
    var maxKIndex = -1
    var culprit = -1
    for (i in array.indices) {
        val value = array[i]
        if (value !in minK..maxK) {
            culprit = i
        }
        if (value == minK) {
            minKIndex = i
        }
        if (value == maxK) {
            maxKIndex = i
        }
        val min = minOf(minKIndex, maxKIndex)
        val temp = min - culprit
        count += if (temp <= 0) 0 else temp
    }
    return count
}

fun main() {
    println(
        countSubArrays(
            intArrayOf(1, 3, 5, 2, 7, 5, 2),
            1,
            5
        )
    )
}