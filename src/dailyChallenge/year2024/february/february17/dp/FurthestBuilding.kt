package dailyChallenge.year2024.february.february17.dp

fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int, index: Int = 0): Int {
    val furthest = when {
        index == heights.lastIndex && (ladders >= 0 || bricks >= 0) -> index
        bricks < 0 -> index - 1
        ladders < 0 -> index - 1
        heights[index] >= heights[index + 1] -> furthestBuilding(heights, bricks, ladders, index + 1)
        else -> {
            val heightDiff = heights[index + 1] - heights[index]
            val bricked = furthestBuilding(heights, bricks - heightDiff, ladders, index + 1)
            val lads = furthestBuilding(heights, bricks, ladders - 1, index + 1)
            maxOf(bricked, lads)
        }
    }
    return furthest
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
            intArrayOf(14, 3, 19, 3),
            17,
            0
        )
    )
}