package dailyChallenge.year2024.may.may27

fun specialArray(array: IntArray): Int {
    array.sort()
    val newArray = IntArray(array.size + 1) {
        val index = array.indexOfFirst { value -> value >= it }
        if (index == -1) 0 else array.size - index
    }
    for ((index, value) in newArray.withIndex()) {
        if (index == value) return value
    }
    return -1
}

fun main() {
    println(
        specialArray(
            intArrayOf(3, 5)
        )
    )
}