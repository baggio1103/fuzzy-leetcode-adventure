package bytebytego.twopointers

fun main() {
    println(maxArea(intArrayOf(2, 7, 8, 3, 7, 6)))
    println(maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
}

fun maxArea(height: IntArray): Int {
    var area = 0
    var i = 0
    var j = height.size - 1
    while (i < j) {
        area = maxOf(
            area,
            minOf(height[i], height[j]) * (j - i)
        )
        if (height[i] > height[j]) j-- else i++
    }
    return area
}
