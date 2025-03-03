package dailyChallenge.year2025.march.march3

fun pivotArray(array: IntArray, pivot: Int): IntArray {
    val list = mutableListOf<Int>()
    array.forEach { value -> if (value < pivot) list.add(value) }
    array.forEach { value -> if (value == pivot) list.add(value) }
    array.forEach { value -> if (value > pivot) list.add(value) }
    return list.toIntArray()
}

fun main() {
    println(
        pivotArray(array = intArrayOf(9, 12, 5, 10, 14, 3, 10), 10).contentToString()
    )
    println(
        pivotArray(array = intArrayOf(-3, 4, 3, 2), 2).contentToString()
    )
}