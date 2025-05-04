package dailyChallenge.year2025.may.may4

fun main() {
    println(
        minDominoRotations(tops = intArrayOf(2, 1, 2, 4, 2, 2), bottoms = intArrayOf(5, 2, 6, 2, 3, 2))
    )
    println(
        minDominoRotations(tops = intArrayOf(3, 5, 1, 2, 3), bottoms = intArrayOf(3, 6, 3, 3, 4))
    )
    println(
        minDominoRotations(
            tops = intArrayOf(2, 2, 5, 1, 5),
            bottoms = intArrayOf(5, 5, 2, 5, 5)
        )
    )
}

//[2,1,2,4,2,2]
//[5,2,6,2,3,2]

//[3,5,1,2,3]
//[3,6,3,3,4]
fun minDominoRotations(tops: IntArray, bottoms: IntArray): Int {
    fun findMin(value: Int): Int {
        var bottomRotations = 0
        var topRotations = 0
        for (i in tops.indices) {
            val top = tops[i]
            val bottom = bottoms[i]
            if (top != value && bottom != value) return Int.MAX_VALUE
            if (top != value) topRotations++
            if (bottom != value) bottomRotations++
        }
        return minOf(bottomRotations, topRotations)
    }
    val result = minOf(findMin(tops[0]), findMin(bottoms[0]))
    return if (result != Int.MAX_VALUE) result else -1
}