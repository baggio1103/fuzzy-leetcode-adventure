package dailyChallenge.year2025.march.march3

fun pivotArray(array: IntArray, pivot: Int): IntArray {
    val resultArray = IntArray(array.size)
    var index = 0
    array.forEach { value ->
        if (value < pivot) {
            resultArray[index] = value
            index++
        }
    }
    array.forEach { value ->
        if (value == pivot) {
            resultArray[index] = value
            index++
        }
    }
    array.forEach { value ->
        if (value > pivot) {
            resultArray[index] = value
            index++
        }
    }
    return resultArray
}

fun main() {
    println(
        pivotArray(array = intArrayOf(9, 12, 5, 10, 14, 3, 10), 10).contentToString()
    )
    println(
        pivotArray(array = intArrayOf(-3, 4, 3, 2), 2).contentToString()
    )
}