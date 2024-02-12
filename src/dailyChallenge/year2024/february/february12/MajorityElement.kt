package dailyChallenge.year2024.february.february12

fun majorityElement(array: IntArray): Int {
    var majorElement = array[0]
    var count = 1
    for (i in 1 until array.size) {
        if (array[i] == majorElement) {
            count++
            continue
        }
        if (count == 0) {
            majorElement = array[i]
            count++
            continue
        }
        count--
    }
    return majorElement
}

fun main() {
    println(
        majorityElement(
            intArrayOf(2, 1, 1, 2, 1, 1, 1, 2, 2)
        )
    )
    println(
        majorityElement(
            intArrayOf(2, 2, 1, 1, 1, 2, 2)
        )
    )
}