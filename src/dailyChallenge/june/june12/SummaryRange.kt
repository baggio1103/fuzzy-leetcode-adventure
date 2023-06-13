package dailyChallenge.june.june12

class SummaryRange {

    fun summaryRanges(array: IntArray): List<String> {
        if (array.isEmpty()) {
            return emptyList()
        }
        val ranges = mutableListOf<String>()
        var startingIndex: Int? = null
        for (i in 0 until array.lastIndex) {
            if (array[i + 1] - array[i] == 1) {
                if (startingIndex == null) {
                    startingIndex = i
                }
            } else {
                startingIndex?.let {
                    ranges.add("${array[it]}->${array[i]}")
                } ?: run {
                    ranges.add("${array[i]}")
                }
                startingIndex = null
            }
        }
        startingIndex?.let {
            ranges.add("${array[startingIndex]}->${array[array.lastIndex]}")
        } ?: run {
            ranges.add("${array[array.lastIndex]}")
        }
        return ranges
    }

}

fun main() {
    val summaryRange = SummaryRange()

    println(summaryRange.summaryRanges(
        intArrayOf(0,1,2,4,5,7)
    ))

    println(summaryRange.summaryRanges(
        intArrayOf(0,2,3,4,6,8,9)
    ))
}