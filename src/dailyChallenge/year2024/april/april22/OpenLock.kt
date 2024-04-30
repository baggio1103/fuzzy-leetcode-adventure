package dailyChallenge.year2024.april.april22

import java.util.ArrayDeque

val nextSlot = mapOf(
    '0' to '1',
    '1' to '2',
    '2' to '3',
    '3' to '4',
    '4' to '5',
    '5' to '6',
    '6' to '7',
    '7' to '8',
    '8' to '9',
    '9' to '0',
)

val prevSlot = mapOf(
    '0' to '9',
    '1' to '0',
    '2' to '1',
    '3' to '2',
    '4' to '3',
    '5' to '4',
    '6' to '5',
    '7' to '6',
    '8' to '7',
    '9' to '8',
)

fun openLock(deadEnds: Array<String>, target: String): Int {
    val visitedCombinations = hashSetOf(*deadEnds)
    val queue = ArrayDeque<String>()
    var turns = 0
    if (visitedCombinations.contains("0000")) return -1
    visitedCombinations.add("0000")
    queue.add("0000")
    while (queue.isNotEmpty()) {
        for (i in 0 until queue.size) {
            val currentCombination = queue.poll()
            if (currentCombination == target) return turns
            for (j in 0 until 4) {
                var newCombination = StringBuilder(currentCombination)

                newCombination.setCharAt(j, nextSlot.getValue(newCombination[j]))

                if (!visitedCombinations.contains(newCombination.toString())) {
                    visitedCombinations.add(newCombination.toString())
                    queue.offer(newCombination.toString())
                }
                newCombination = StringBuilder(currentCombination)
                newCombination.setCharAt(j, prevSlot.getValue(newCombination[j]))

                if (!visitedCombinations.contains(newCombination.toString())) {
                    visitedCombinations.add(newCombination.toString())
                    queue.offer(newCombination.toString())
                }
            }
        }
        turns++
    }
    return -1
}

fun main() {
    println(
        openLock(
            deadEnds = arrayOf(
                "0201", "0101", "0102", "1212", "2002"
            ), "0202"
        )
    )
}