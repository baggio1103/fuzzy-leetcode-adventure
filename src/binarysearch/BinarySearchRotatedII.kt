package binarysearch

class BinarySearchRotatedII {

    fun search(array: IntArray, target: Int, begin: Int = 0, end: Int = array.lastIndex): Boolean {
        if (begin > end) {
            return false
        }
        val middle = (begin + end) / 2
        val result = binarySearch(array, target, begin, end)
        if (result == 1) {
            return true
        }
        if (search(array, target, begin, middle - 1)) {
            return true
        }
        return search(array, target, middle + 1, end)
    }

    fun binarySearch(array: IntArray, target: Int, from: Int, to: Int): Int {
        var begin = from
        var end = to
        while (begin <= end) {
            val middle = (begin  + end) / 2
            if (array[middle] == target) {
                return 1
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
    val search = BinarySearchRotatedII()
    search.search(intArrayOf(
        0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    ),
        5)
        .let { println(it) }


    search.search(
        intArrayOf(
        7, 8, 9, 0, 1, 2, 3, 4, 5, 6,
    ),
        8)
        .let { println(it) }

    println(
        search.binarySearch(
            intArrayOf(
                7, 8, 9, 0, 1, 2, 3, 4, 5, 6,
            ),
            8, 0, 9)
        )

}