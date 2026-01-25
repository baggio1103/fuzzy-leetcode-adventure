package bytebytego.binarysearch

fun main() {
    println(cuttingWood(intArrayOf(2, 6, 3, 8), 7))
}

fun cuttingWood(trees: IntArray, k: Int): Int {
    fun isEnoughWood(height: Int): Boolean = trees.sumOf { if (it > height) it - height else 0 } >= k
    var left = 0
    var right = trees.max()
    while (left < right) {
        val middle = left + (right - left) / 2 + 1
        if (isEnoughWood(middle))
            left = middle
        else right = middle - 1
    }
    return right
}
