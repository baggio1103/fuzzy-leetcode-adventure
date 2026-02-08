package dailyChallenge.year2026.february.february3

fun main() {
//    println(
//        isTrionic(intArrayOf(1, 3, 5, 4, 2, 9, 10, 1))
//    )
    println(
        isTrionic(intArrayOf(2, 1, 3))
    )
}

fun isTrionic(array: IntArray): Boolean {
    val n = array.size
    var i = 1
    while (i < n && array[i] > array[i - 1]) i++

    val p = i - 1
    while (i < n && array[i] < array[i - 1]) i++

    val q = i - 1
    while (i < n && array[i] > array[i - 1]) i++
    val result = i - 1
    return (p != 0) && (q != p) && (result == n && result != q)
}
