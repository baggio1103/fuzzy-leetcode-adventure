package sorting

class MergeInterval {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { a: IntArray, b: IntArray ->
            if (a[0] > b[0]) {
                1
            } else if (a[0] < b[0]) {
                -1
            } else
                0
        }
        val lastIndex = intervals.lastIndex
        val nonOverlappingIntervals = mutableListOf<IntArray>()
        for (i in 0 until lastIndex) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                if (intervals[i][1] >= intervals[i + 1][1]) {
                    intervals[i + 1] = intArrayOf(intervals[i][0], intervals[i][1])
                } else {
                    intervals[i + 1] = intArrayOf(intervals[i][0], intervals[i + 1][1])
                }
            } else {
                nonOverlappingIntervals.add(intervals[i])
            }
        }
        nonOverlappingIntervals.add(intervals[lastIndex])
        return nonOverlappingIntervals.toTypedArray()
    }

}

fun main() {
    val intervals = MergeInterval()
    intervals.merge(
        arrayOf(
            intArrayOf(15, 18),
            intArrayOf(8, 10),
            intArrayOf(1, 3),
            intArrayOf(2, 6),
        )
    ).forEach {
        println(it.toList())
    }
    println("-=-=-=-=-=-=-=-=-=-=-=")
    intervals.merge(
        arrayOf(
            intArrayOf(1, 4),
            intArrayOf(4, 5)
        )
    ).forEach {
        println(it.toList())
    }
    println("-=-=-=-=-=-=-=-=-=-=-=")
    intervals.merge(
        arrayOf(
            intArrayOf(1, 4),
            intArrayOf(2, 3)
        )
    ).forEach {
        println(it.toList())
    }

}