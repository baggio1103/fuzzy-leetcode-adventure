package bytebytego.graphs

import java.util.ArrayDeque

fun main() {
    require(
        matrixInfection(
            arrayOf(
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 0, 2, 1),
                intArrayOf(0, 1, 1, 0),
            )
        ) == 3
    )
    require(
        matrixInfection(
            arrayOf(
                intArrayOf(1, 2, 1, 0, 1),
                intArrayOf(1, 0, 0, 1, 1),
                intArrayOf(1, 2, 0, 0, 2),
            )
        ) == 2
    )
    require(
        matrixInfection(
            arrayOf(
                intArrayOf(1, 2, 1),
                intArrayOf(0, 0, 0),
                intArrayOf(1, 0, 0),
            )
        ) == -1
    )
}

fun matrixInfection(matrix: Array<IntArray>): Int {

    val queue = ArrayDeque<Pair<Int, Int>>()
    val rows = matrix.size
    val cols = matrix[0].size
    var uninfected = 0
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            if (matrix[i][j] == 2)
                queue.offer(i to j)
            if (matrix[i][j] == 1)
                uninfected++
        }
    }
    var seconds = 0
    while (queue.isNotEmpty() && uninfected != 0) {
        val size = queue.size
        repeat(size) {
            val (r, c) = queue.poll()
            arrayOf(r + 1 to c, r - 1 to c, r to c + 1, r to c - 1).forEach { (r, c) ->
                if (
                    r in 0 until rows
                    && c in 0 until cols
                    && matrix[r][c] == 1
                ) {
                    queue.offer(r to c)
                    matrix[r][c] = 2
                    uninfected--
                }
            }
        }
        seconds++
    }
    return if (uninfected != 0) -1 else seconds
}