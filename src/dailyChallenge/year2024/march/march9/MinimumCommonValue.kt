package dailyChallenge.year2024.march.march9

fun getCommon(arrayOne: IntArray, arrayTwo: IntArray): Int {
    var i = 0
    var j = 0
    while (i < arrayOne.size && j < arrayTwo.size) {
        when {
            arrayOne[i] == arrayTwo[j] -> return arrayOne[i]
            arrayOne[i] > arrayTwo[j] -> j++
            arrayOne[i] < arrayTwo[j] -> i++
        }
    }
    return -1
}

fun main() {
    println(
        getCommon(
            intArrayOf(11, 15, 28, 31, 36, 42, 46, 54, 58, 63, 64, 67, 75, 76, 76, 79, 83, 85, 87, 90),
            intArrayOf(3, 6, 8, 13, 15, 19, 22, 25, 29, 29, 32, 35, 43, 43, 48, 55, 81, 90, 91, 94)
        )
    )
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