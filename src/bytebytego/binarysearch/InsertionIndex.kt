package bytebytego.binarysearch

fun main() {
    println(searchInsert(intArrayOf(1, 2, 4, 5, 7, 8, 9), 4))
    println(searchInsert(intArrayOf(1, 2, 4, 5, 7, 8, 9), 6))
    println(searchInsert(intArrayOf(1, 2, 4, 5, 7, 8, 9), 10))
    println(searchInsert(intArrayOf(1, 2, 4, 5, 7, 8, 9), -1))
    println(searchInsert(intArrayOf(1), 1))
}

fun searchInsert(array: IntArray, target: Int): Int {
    var l = 0
    var r = array.size
    while (l < r) {
        val mid = l + (r - l) / 2
        if (array[mid] >= target)
            r = mid
        else l = mid + 1
    }
    return l
}
