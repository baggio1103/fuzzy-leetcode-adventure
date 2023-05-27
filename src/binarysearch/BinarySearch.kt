package binarysearch

class BinarySearch {
    fun search(array: IntArray, target: Int): Int {
        var begin = 0
        var end = array.lastIndex
        while (begin <= end) {
            val middle = (begin + end) / 2
            if (array[middle] == target) {
                return middle
            }
            if (array[middle] > target) {
                end = middle - 1
            }
            if (array[middle] < target) {
                begin = middle + 1
            }
        }
        return -1
    }

}

fun main() {
    val binarySearch = BinarySearch()
    println(
        binarySearch.search(
            intArrayOf(1, 2, 3, 4),
            3
        )
    )
}