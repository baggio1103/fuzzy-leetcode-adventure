package bytebytego.binarysearch

fun main() {
    println(search(intArrayOf(2, 2), 3).contentToString())



    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString())
    println(searchRange(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentToString())
    println(searchRange(intArrayOf(), 0).contentToString())
    println(searchRange(intArrayOf(1), 1).contentToString())
    println(searchRange(intArrayOf(3, 3, 3), 3).contentToString())

    println("-==-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=-==-=-=-=-=-=")
    println(search(intArrayOf(5, 7, 7, 8, 8, 10), 8).contentToString())
    println(search(intArrayOf(5, 7, 7, 8, 8, 10), 6).contentToString())
    println(search(intArrayOf(), 0).contentToString())
    println(search(intArrayOf(1), 1).contentToString())
    println(search(intArrayOf(3, 3, 3), 3).contentToString())

}

fun search(array: IntArray, target: Int): IntArray {
    fun lowerBoundSearch(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2
            if (array[mid] > target)
                right = mid - 1
            else if (array[mid] < target)
                left = mid + 1
            else right = mid
        }
        return if (array[left] != target) -1 else left
    }

    fun upperBoundSearch(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size - 1
        while (left < right) {
            val mid = left + (right - left) / 2 + 1
            if (array[mid] > target)
                right = mid - 1
            else if (array[mid] < target)
                left = mid + 1
            else left = mid
        }
        return if (array[right] != target) -1 else right
    }
    return if (array.isEmpty()) intArrayOf(-1, -1)
    else intArrayOf(
        lowerBoundSearch(array, target),
        upperBoundSearch(array, target)
    )
}

fun searchRange(array: IntArray, target: Int): IntArray {
    fun search(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (array[mid] >= target) right = mid else left = mid + 1
        }
        return left
    }

    val index = search(array, target)
    if (index == array.size || array[index] != target) return intArrayOf(-1, -1)
    val lastIndex = search(array, target + 1)
    return intArrayOf(index, if (lastIndex == array.size || array[lastIndex] != target) lastIndex - 1 else lastIndex)
}
