package dailyChallenge.year2024.march.march10

fun intersection(arrayOne: IntArray, arrayTwo: IntArray): IntArray {
    val set = hashSetOf<Int>().apply {
        arrayOne.forEach { add(it) }
    }
    val intersection = hashSetOf<Int>()
    arrayTwo.forEach {
        if (set.contains(it)) {
            intersection.add(it)
        }
    }
    return intersection.toIntArray()
}

fun main() {
    println(
        intersection(
            intArrayOf(1, 2, 2, 4),
            intArrayOf(2, 2)
        )
    )
}