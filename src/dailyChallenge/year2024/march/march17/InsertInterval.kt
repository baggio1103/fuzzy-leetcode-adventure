package dailyChallenge.year2024.march.march17

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf(newInterval)
    val list = intervals.toMutableList()
    when {
        newInterval[0] < list[0][0] -> list.add(0, newInterval)
        newInterval[0] > list.last()[0] -> list.add(newInterval)
        else -> {
            for (i in list.indices) {
                if (newInterval[0] <= list[i][0]) {
                    list.add(i, newInterval)
                    break
                }
            }
        }
    }
    var i = 1
    while (i < list.size) {
        val (left, right) = Pair(list[i - 1], list[i])
        if (left[1] < right[0]) {
            i++
            continue
        }
        list.removeAt(i - 1)
        list.removeAt(i - 1)
        i--
        list.add(i, intArrayOf(left[0], maxOf(left[1], right[1])))
        i++
    }
    return list.toTypedArray()
}

fun main() {
    println(
        insert(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(6, 9)
            ),
            intArrayOf(2, 5)
        )
    )
    insert(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9)
        ),
        intArrayOf(0, 5)
    )
    insert(
        arrayOf(
            intArrayOf(1, 3),
            intArrayOf(6, 9)
        ),
        intArrayOf(6, 10)
    )
}