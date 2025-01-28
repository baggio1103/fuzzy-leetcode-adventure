package dailyChallenge.year2025.january.january25

import kotlin.math.abs


fun main() {
    println(
        lexicographicallySmallestArray(array = intArrayOf(1, 7, 6, 18, 2, 1), 3)
            .contentToString()
    )
    println(
        lexicographicallySmallestArray(array = intArrayOf(1, 5, 3, 9, 8), 2)
            .contentToString()
    )
}

fun lexicographicallySmallestArray(array: IntArray, limit: Int): IntArray {
    val sortedArray = array.copyOf().sortedArray()
    val valueByGroup = mutableMapOf<Int, Int>()
    val groupedLists = mutableMapOf<Int, ArrayDeque<Int>>()
    var currentGroup = 0
    groupedLists[currentGroup] = ArrayDeque<Int>().apply { addLast(sortedArray[0]) }
    valueByGroup[sortedArray[0]] = 0
    for (i in 1 until array.size) {
        if (abs(sortedArray[i] - sortedArray[i - 1]) > limit) currentGroup++
        valueByGroup[sortedArray[i]] = currentGroup
        if (!groupedLists.containsKey(currentGroup)) {
            groupedLists[currentGroup] = ArrayDeque()
        }
        groupedLists[currentGroup]?.addLast(sortedArray[i])
    }
    for ((index, value) in array.withIndex()) {
        val group = valueByGroup.getValue(value)
        array[index] = groupedLists.getValue(group).removeFirst()
    }
    return array
}
