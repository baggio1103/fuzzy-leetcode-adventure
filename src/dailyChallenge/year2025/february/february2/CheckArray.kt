package dailyChallenge.year2025.february.february2

// 3,4,5,1,2
// 5 4 3 2 1 -> 1 5 4 3 2 ->

fun main() {
    println(
        check(array = intArrayOf(3, 4, 5, 1, 2))
    )
    println(
        linearCheck(array = intArrayOf(3, 4, 5, 1, 2))
    )
}

fun check(array: IntArray): Boolean {
    val original = array.sortedArray()
    val copy = IntArray(array.size) { -1 }
    array.indices.forEach { step ->
        for (i in original.indices) {
            copy[i] = original[(i + step) % array.size]
        }
        if (copy.contentEquals(array)) {
            return true
        }
    }
    return false
}


fun linearCheck(array: IntArray): Boolean {
    var inversionCount = 0
    if (array.size <= 1) return true
    for (i in 1 until array.size) {
        if (array[i] < array[i - 1]) {
            inversionCount++
        }
    }
    if (array[0] < array.last()) inversionCount++
    return inversionCount <= 1
}