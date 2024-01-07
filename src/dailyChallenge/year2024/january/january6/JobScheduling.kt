package dailyChallenge.year2024.january.january6

fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val lastIndex = startTime.lastIndex
    val memo = mutableMapOf<Int, Int>()
    val data = List(startTime.size) { index ->
        Triple(startTime[index], endTime[index], profit[index])
    }.sortedBy { it.first }

    fun jobScheduling(startTimeIndex: Int = 0, memo: MutableMap<Int, Int>): Int {
        val memoValue = memo[startTimeIndex]
        if (memoValue != null) {
            return memoValue
        }
        val (_, end, profitValue) = data[startTimeIndex]
        val nextJobStartIndex = IntRange(startTimeIndex + 1, lastIndex).firstOrNull {
            data[it].first >= end
        } ?: -1

        if (nextJobStartIndex == -1) {
            return profitValue
        }
        val range = nextJobStartIndex..lastIndex
        val result = range.maxOf {
            profitValue + jobScheduling(it, memo)
        }
        memo[startTimeIndex] = result
        return result
    }

    return IntRange(0, lastIndex).maxOf { jobScheduling(it, memo) }
}


fun main() {
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