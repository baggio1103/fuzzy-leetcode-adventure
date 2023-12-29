package dailyChallenge.december.december29

//fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
//}

fun minDifficulty(jobDifficulty: IntArray, days: Int, currentDay: Int = 1, currentIndex: Int = 0): Int {
    if (days > jobDifficulty.size) {
        return -1
    }
    if (currentDay == days) {
        val baseCase = jobDifficulty.sliceArray(currentIndex .. jobDifficulty.lastIndex)
        val max = baseCase.max()
//        println("Base case: ${baseCase.asList()} and max: $max")
        return max
    }
    val diff = days - currentDay
    val jobsRange = currentIndex ..  jobDifficulty.lastIndex - diff
    // 0 1 2 3
//    println("Range: $jobsRange")
    val jobsSchedule = mutableListOf<Int>()
    jobsRange.forEach { index ->
        // 0
        val array = jobDifficulty.sliceArray(currentIndex..index)
        val arrayMax = array.max()
//        println("Result: ${array.asList()} and max: $arrayMax")
        val nextDaysDifficulty = minDifficulty(jobDifficulty, days, currentDay + 1, index + 1)
        // 01
        jobsSchedule.add(arrayMax + nextDaysDifficulty)
        // 012

        // 0123
    }
    return jobsSchedule.min()
}

fun main() {
    println(
        minDifficulty(
            intArrayOf(6, 5, 4, 3, 2, 1), 3
        )
    )
    println(
        minDifficulty(
            intArrayOf(6,5,4,3,2,1), 2
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
}