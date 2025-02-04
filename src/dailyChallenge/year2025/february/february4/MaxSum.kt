package dailyChallenge.year2025.february.february4

fun main() {
    println(
        maxAscendingSum(intArrayOf(10, 20, 30, 5, 10, 50))
    )
    println(maxAscendingSum(intArrayOf(3, 6, 10, 1, 8, 9, 9, 8, 9)))
}

fun maxAscendingSum(array: IntArray): Int {
    var max = array[0]
    var sum = array[0]
    for (i in 1 until array.size) {
        if (array[i] <= array[i - 1]) {
            max = maxOf(max, sum)
            sum = array[i]
        } else {
            sum += array[i]
        }
    }
    return maxOf(max, sum)
}