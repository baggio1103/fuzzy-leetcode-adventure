package dailyChallenge.december.december18

fun maxProductDifference(array: IntArray): Int {
    array.sort()
    val (a, b) = Pair(array.last(), array[array.lastIndex - 1])
    val (c, d) = Pair(array[0], array[1])
    return (a * b) - (c * d)
//    return array.takeLast(2).reduce { acc, i -> acc * i } - array.take(2).reduce {acc, i -> acc * i }
}

fun main() {
    println(
        maxProductDifference(
            intArrayOf(5, 6, 2, 7, 4)
        )
    )
    println(
        maxProductDifference(
            intArrayOf(4, 2, 5, 9, 7, 4, 8)
        )
    )
}