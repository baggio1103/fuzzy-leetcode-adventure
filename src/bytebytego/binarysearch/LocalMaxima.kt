package bytebytego.binarysearch

fun main() {
    println(searchLocalMaxima(intArrayOf(1, 4, 3, 2, 3)))
}


fun searchLocalMaxima(array: IntArray): Int {
    var left = 0
    var right = array.size - 1
    while (left < right) {
        val mid = left + (right - left) / 2
        if (array[mid] < array[mid + 1]) {
          left = mid + 1
        } else right = mid
    }
    return array[left]
}