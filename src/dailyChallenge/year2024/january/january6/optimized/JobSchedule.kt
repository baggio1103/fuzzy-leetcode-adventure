package dailyChallenge.year2024.january.january6.optimized

import kotlin.math.min

fun jobScheduling(startTimeArray: IntArray, endTimeArray: IntArray, profit: IntArray): Int {
    val lastIndex = startTimeArray.lastIndex
    val memo = mutableMapOf<Int, Int>()
    val data = List(startTimeArray.size) { index ->
        Triple(startTimeArray[index], endTimeArray[index], profit[index])
    }.sortedBy { it.first }

    fun jobScheduling(startTimeIndex: Int = 0, memo: MutableMap<Int, Int>): Int {
        val memoValue = memo[startTimeIndex]
        if (memoValue != null) {
            return memoValue
        }
        val (_, endTime, profitValue) = data[startTimeIndex]
        val nextJobStartIndex = binarySearch(startTimeIndex + 1, lastIndex, data, endTime)

        if (nextJobStartIndex == -1) {
            memo[startTimeIndex] = profitValue
            return profitValue
        }
        val range = nextJobStartIndex..lastIndex
        val result = range.maxOf {
            profitValue + (memo[it] ?: jobScheduling(it, memo))
        }
        memo[startTimeIndex] = result
        return result
    }

    return IntRange(0, lastIndex).maxOf { jobScheduling(it, memo) }
}

fun binarySearch(startIndex: Int, lastIndex: Int, data: List<Triple<Int, Int, Int>>, searchValue: Int): Int {
    var start = startIndex
    var middle: Int
    while (start <= lastIndex) {
        middle = start + (lastIndex - start) / 2
        val value = data[middle].first
        if (value >= searchValue) {
            val leftSideValue = binarySearch(start, middle - 1, data, searchValue)
            if (leftSideValue == -1) {
                return middle
            }
            return min(middle, leftSideValue)
        }
        start = middle + 1
    }
    return -1
}


fun main() {
//    val array = listOf(1, 3, 3, 6, 17)
//    println(
//        binarySearch(0, array.lastIndex, array, 122)
//    )

//    println(
//        binarySearch(0, array.lastIndex, array, 15)
//    )


    val (a, b, c) = Triple(
        intArrayOf(  1,  2, 3,  6,  7,  11, 15,  16),
        intArrayOf( 10,  8, 8, 19, 19,  16, 18,  19),
        intArrayOf( 5,  19, 7,  2,   1,  19,  9,  3)
    )

    println(
        jobScheduling(a, b, c)
    )

    println(
        jobScheduling(
            intArrayOf(1, 2, 3, 3),
            intArrayOf(3, 4, 5, 6),
            intArrayOf(50, 10, 40, 70)
        )
    )

    println(
        jobScheduling(
            intArrayOf(1, 2, 3, 3, 4),
            intArrayOf(3, 4, 5, 6, 6),
            intArrayOf(50, 80, 40, 70, 120)
        )
    )

    println(
        jobScheduling(
            intArrayOf(1, 1, 1),
            intArrayOf(2, 3, 4),
            intArrayOf(4, 5, 6)
        )
    )

    println(
        jobScheduling(
            intArrayOf(1, 2, 3, 4, 6),
            intArrayOf(3, 5, 10, 6, 9),
            intArrayOf(20, 20, 100, 70, 60)
        )
    )

}