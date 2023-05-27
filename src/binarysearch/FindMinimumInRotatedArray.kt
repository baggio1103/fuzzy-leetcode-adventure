package binarysearch

class FindMinimumInRotatedArray {

    fun findMin(array: IntArray): Int {
        var start = 0
        var end = array.lastIndex
        while (start < end) {
            val mid = start + (end - start) / 2
            if (array[mid] > array[end]) start = mid + 1
            if (array[mid] < array[end]) end = mid
        }
        return array[start]
    }

}

fun main() {
    val findMinimumInRotatedArray = FindMinimumInRotatedArray()
    println(
        findMinimumInRotatedArray.findMin(
            intArrayOf(3, 4, 5, 6, 7, 8, 0, 1, 2)
        )
    )
}