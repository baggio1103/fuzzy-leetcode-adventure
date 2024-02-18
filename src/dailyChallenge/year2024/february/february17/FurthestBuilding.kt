package dailyChallenge.year2024.february.february17

import java.util.Comparator
import java.util.PriorityQueue

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
    val jumps = PriorityQueue<Int>(Comparator.reverseOrder())
    var usedBricks = bricks
    var usedLadders = ladders
    for (i in 1 until heights.size) {
        val jump = heights[i] - heights[i - 1]
        if (jump < 0) continue
        usedBricks -= jump
        jumps.add(jump)
        if (usedBricks < 0) {
            if (usedLadders == 0) return i - 1
            usedLadders--
            usedBricks += jumps.poll()
        }
    }
    return heights.lastIndex
}

fun main() {
    println(
        furthestBuilding(
            intArrayOf(4, 2, 7, 6, 9, 14, 12),
            5,
            1
        )
    )
    println(
        furthestBuilding(
            intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19),
            10,
            2
        )
    )
    println(
        furthestBuilding(
            intArrayOf(4, 6, 7, 9, 14, 12),
            5,
            1
        )
    )
    println(
        furthestBuilding(
            intArrayOf(14, 3, 19, 3),
            17,
            0
        )
    )
}