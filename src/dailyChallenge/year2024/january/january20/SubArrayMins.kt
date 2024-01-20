package dailyChallenge.year2024.january.january20

fun sumSubArrayMinimums(array: IntArray): Int {
    val mod = 1_000_000_007
    val slides = 0..array.lastIndex
    var count = 0
    slides.forEach { slide ->
        var minIndex = -1
        for (i in array.indices) {
            if (i + slide >= array.size) {
                continue
            }
            val range = i..i + slide
            if (minIndex in range && array[range.last] < array[minIndex]) {
                minIndex = range.last
                count += array[minIndex]
                count %= mod
                continue
            }
            if (minIndex in range) {
                count += array[minIndex]
                count %= mod
                continue
            }
            // To optimize
            val index = minIndex(range, array)
            minIndex = index
            count += array[minIndex]
            count %= mod
        }
    }
    return count
}

fun minIndex(range: IntRange, array: IntArray): Int {
    var index = range.first
    for (i in range) {
        if (array[index] > array[i]) {
            index = i
        }
    }
    return index
}

fun main() {
    println(
        sumSubArrayMinimums(
            intArrayOf(3, 1, 2, 4)
        )
    )
    println(
        sumSubArrayMinimums(
            intArrayOf(11, 81, 94, 43, 3)
        )
    )
}