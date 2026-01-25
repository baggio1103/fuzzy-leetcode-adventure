package bytebytego.binarysearch

fun main() {
    println(select(intArrayOf(3, 1, 2, 4), 5))
}

fun select(array: IntArray, target: Int): Int {
    val prefixSum = IntArray(array.size)
    prefixSum[0] = array[0]
    for (i in 1 until array.size) {
        prefixSum[i] += array[i] + prefixSum[i - 1]
    }
    var left = 0
    var right = array.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (prefixSum[mid] >= target) {
            right = mid
        } else
            left = mid + 1
    }
    return left
}
