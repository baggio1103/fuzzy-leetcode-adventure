package dailyChallenge.year2025.march.march1

fun main() {
    println(
        applyOperations(
            intArrayOf(1, 2, 2, 1, 1, 0)
        ).contentToString()
    )
    println(
        applyOperations(
            intArrayOf(0, 1)
        ).contentToString()
    )
}

fun applyOperations(array: IntArray): IntArray {
    val newArray = IntArray(array.size)
    for (i in 0 until array.lastIndex) {
        if (array[i] == array[i + 1]) {
            array[i] = array[i] * 2
            array[i + 1] = 0
        }
    }
    println(array.contentToString())
    var i = 0
    for (value in array) {
        if (value != 0) {
            newArray[i] = value
            i++
        }
    }
    return newArray
}