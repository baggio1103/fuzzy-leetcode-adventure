package bytebytego.binarysearch

import bytebytego.binarysearch.Search.search

fun main() {
    println(search(intArrayOf(8, 9, 1, 2, 3, 4, 5, 6, 7), 1))
    println(search(intArrayOf(8, 9, 1, 2, 3, 4, 5, 6, 7), 7))
    println(search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    println(search(intArrayOf(1), 0))
    println(search(intArrayOf(4, 5, 6, 7, 8, 1, 2, 3), 8))
    println(search(intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 1), 1))
}

object Search {

    fun search(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (array[mid] == target) return mid

            if (array[mid] <= array[right]) {
                if (target >= array[mid] && target <= array[right]) {
                    left = mid + 1
                } else {
                    right = mid - 1
                }
            } else {
                if (target >= array[left] && target <= array[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }
        }
        return -1
    }

}
