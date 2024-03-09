package dailyChallenge.year2024.march.march9.map

fun getCommon(arrayOne: IntArray, arrayTwo: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    arrayOne.forEach {
        if (map[it] == null) {
            map[it] = 1
        }
    }
    arrayTwo.forEach {
        if (map[it] == 1) return it
    }
    return -1
}

fun main() {
    println(
        getCommon(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 4)
        )
    )
    println(
        getCommon(
            intArrayOf(13, 14),
            intArrayOf(2, 12, 13)
        )
    )
}