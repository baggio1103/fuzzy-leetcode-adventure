package dailyChallenge.year2025.february.february1

fun main() {
    println(
        isArraySpecial(array = intArrayOf(1))
    )
    println(
        isArraySpecial(array = intArrayOf(2, 1, 4))
    )
    println(
        isArraySpecial(array = intArrayOf(4, 3, 1, 6))
    )
}

fun isArraySpecial(array: IntArray): Boolean {
    if (array.size == 1) return true
    for (i in 1 until array.size) {
        if (array[i] % 2 == array[i - 1] % 2) return false
    }
    return true
}