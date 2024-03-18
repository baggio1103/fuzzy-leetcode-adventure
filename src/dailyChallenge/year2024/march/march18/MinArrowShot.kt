package dailyChallenge.year2024.march.march18

fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortWith(compareBy { it[0] })
    var prev = points[0]
    var count = 1
    for (i in 1 until points.size) {
        val current = points[i]
        if (prev[1] >= current[0]) {
            prev = intArrayOf(current[0], minOf(prev[1], current[1]))
            continue
        }
        prev = current
        count++
    }
    return count
}

fun main() {
//    [[-1,1],[0,1],[2,3],[1,2]]
    println(
        findMinArrowShots(
            arrayOf(
                intArrayOf(-1, 1),
                intArrayOf(0, 1),
                intArrayOf(2, 3),
                intArrayOf(1, 2)
            )
        )
    )

//    [[10,16],[2,8],[1,6],[7,12]] ---> 2
    println(
        findMinArrowShots(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(2, 8),
                intArrayOf(7, 12),
                intArrayOf(10, 16)
            )
        )
    )
    //// 4
    println(
        findMinArrowShots(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                intArrayOf(5, 6),
                intArrayOf(7, 8)
            )
        )
    )
    println(
        findMinArrowShots(
            arrayOf(
                intArrayOf(3, 9), intArrayOf(7, 12), intArrayOf(3, 8), intArrayOf(6, 8), intArrayOf(9, 10),
                intArrayOf(2, 9), intArrayOf(0, 9), intArrayOf(3, 9), intArrayOf(0, 6), intArrayOf(2, 8)
            )
        )
    )
}