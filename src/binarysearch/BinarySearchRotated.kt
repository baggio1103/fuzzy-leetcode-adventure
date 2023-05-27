package binarysearch

class BinarySearchRotated {

    fun search(array: IntArray, target: Int, begin: Int = 0, end: Int = array.lastIndex): Int {
        if (begin > end) {
            return -1
        }
        val middle = (begin + end) / 2
        val index = binarySearch(array, target, begin, end)
        if (index != -1) {
            return index
        }
        val leftSubArrayIndex = search(array, target, begin, middle - 1)
        if (leftSubArrayIndex != -1) {
            return leftSubArrayIndex
        }
        return search(array, target, middle + 1, end)
    }

    fun binarySearch(array: IntArray, target: Int, from: Int, to: Int): Int {
        var begin = from
        var end = to
        while (begin <= end) {
            val middle = (begin  + end) / 2
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
    val search = BinarySearchRotated()
    search.search(
        intArrayOf(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        ),
        5
    )
        .let { println("Result: $it") }


    search.search(
        intArrayOf(
            7, 8, 9, 0, 1, 2, 3, 4, 5, 6,
        ),
        8
    )
        .let { println("Result: $it") }

    println(
        "Result: ${
            search.binarySearch(
                intArrayOf(
                    7, 8, 9, 0, 1, 2, 3, 4, 5, 6,
                ),
                8, 0, 9
            )
        }"
    )

}