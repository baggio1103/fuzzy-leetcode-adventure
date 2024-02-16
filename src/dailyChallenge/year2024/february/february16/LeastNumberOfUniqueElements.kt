package dailyChallenge.year2024.february.february16

fun findLeastNumOfUniqueElements(array: IntArray, k: Int): Int {
    val map = buildMap {
        array.forEach {
            val count = this[it] ?: 0
            this[it] = count + 1
        }
    }
    val bucketArray = IntArray(array.size + 1) { _ -> 0 }
    for ((_, frequency) in map) {
        bucketArray[frequency]++
    }
    var uniqueElements = map.size
    var count = k
    for (frequency in 1 until  bucketArray.size) {
        val elements = bucketArray[frequency]
        if (count >= elements * frequency) {
            uniqueElements -= elements
            count -= elements * frequency
        } else {
            uniqueElements -= (count / frequency)
            break
        }
    }
    return uniqueElements
}

fun main() {
    println(
        findLeastNumOfUniqueElements(
            intArrayOf(2, 3),
            1
        )
    )
    println(
        findLeastNumOfUniqueElements(
            intArrayOf(2, 4, 1, 8, 3, 5, 1, 3),
            3
        )
    )
    println(
        findLeastNumOfUniqueElements(
            intArrayOf(5, 5, 4),
            1
        )
    )
    println(
        findLeastNumOfUniqueElements(
            intArrayOf(2, 1, 1, 3, 3, 3),
            3
        )
    )
}