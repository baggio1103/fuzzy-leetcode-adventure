package dailyChallenge.december.december29.memo

import kotlin.system.measureTimeMillis

fun minDifficulty(
    jobDifficulty: IntArray,
    days: Int,
    currentDay: Int = 1,
    currentIndex: Int = 0,
    memo: MutableMap<String, Int> = mutableMapOf()
): Int {
    val key = "$currentDay - $currentIndex"
    if (memo[key] != null) {
        return memo[key]!!
    }
    if (days > jobDifficulty.size) {
        return -1
    }
    if (currentDay == days) {
        return jobDifficulty.sliceArray(currentIndex..jobDifficulty.lastIndex).max()
    }
    val diff = days - currentDay
    val jobsRange = currentIndex..jobDifficulty.lastIndex - diff
    var result = Int.MAX_VALUE
    jobsRange.forEach { index ->
        val range = currentIndex..index
        val maxDifficulty = jobDifficulty.sliceArray(range).max()
        val nextDaysDifficulty = minDifficulty(jobDifficulty, days, currentDay + 1, index + 1,  memo)
        val value = (maxDifficulty + nextDaysDifficulty)
        if (result > value) {
            result = value
        }
    }
    memo[key] = result
    return result
}

fun main() {
    println(
        minDifficulty(
            intArrayOf(6, 5, 4, 3, 2, 1), 3
        )
    )
    println(
        minDifficulty(
            intArrayOf(6, 5, 4, 3, 2, 1), 2
        )
    )
    println(
        minDifficulty(
            intArrayOf(1, 1, 1), 3
        )
    )
    println(
        minDifficulty(
            intArrayOf(9, 9, 9), 4
        )
    )

    println(
        "Exec time: ${
            measureTimeMillis {
                println(
                    minDifficulty(
                        intArrayOf(
                            380,
                            302,
                            102,
                            681,
                            863,
                            676,
                            243,
                            671,
                            651,
                            612,
                            162,
                            561,
                            394,
                            856,
                            601,
                            30,
                            6,
                            257,
                            921,
                            405,
                            716,
                            126,
                            158,
                            476,
                            889,
                            699,
                            668,
                            930,
                            139,
                            164,
                            641,
                            801,
                            480,
                            756,
                            797,
                            915,
                            275,
                            709,
                            161,
                            358,
                            461,
                            938,
                            914,
                            557,
                            121,
                            964,
                            315
                        ),
                        10
                    )
                )
            }
        }ms"
    )

}