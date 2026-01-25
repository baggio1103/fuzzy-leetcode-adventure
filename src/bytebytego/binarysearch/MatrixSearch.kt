package bytebytego.binarysearch

fun main() {
    println(
        searchMatrix(
            matrix = arrayOf(
                intArrayOf(2, 3, 4, 6),
                intArrayOf(7, 10, 11, 17),
                intArrayOf(20, 21, 23, 33),
            ),
            2
        )
    )
    println(searchMatrix(arrayOf(intArrayOf(1, 3)), 3))
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val columns = matrix[0].size
    var left = 0
    var right = (rows * columns) - 1
    while (left <= right) {
        val mid = left + (right - left) / 2
        val (r, c) = mid / columns to mid % columns
        if (matrix[r][c] == target) return true
        else if (matrix[r][c] > target) right = mid - 1
        else left = mid + 1
    }
    return false
}
