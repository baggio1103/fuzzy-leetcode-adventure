package dailyChallenge.june.june1.test

class ShortestPath {

    fun shortestPathBinaryMatrix(
        grid: Array<IntArray>,
        currentRow: Int = 0,
        currentColumn: Int = 0,
        rowCount: Int = grid.lastIndex,
        columnCount: Int = grid[0].lastIndex,
        currentNode: Int = 1,
        visitedNodes: HashSet<String> = hashSetOf()
    ): Int {
        var counter = 0
        grid.forEachIndexed { index, values ->
            if (values[index] == 0) {
                counter++
            }
        }
        if (counter == grid.size) {
            return counter
        }
        if (currentRow == rowCount && currentColumn == columnCount) {
            return if (grid[rowCount][columnCount] == 0) currentNode else -1
        }
        if (currentRow < 0 || currentRow > rowCount || currentColumn < 0 || currentColumn > columnCount) {
            return -1
        }
        if (grid[currentRow][currentColumn] != 0) {
            return -1
        }
        return if (currentRow == 0) {
            listOf(
                Pair(currentRow, currentColumn + 1),
                Pair(currentRow + 1, currentColumn + 1),
                Pair(currentRow + 1, currentColumn),
            ).filter {
                !visitedNodes.contains("${it.first}-${it.second}")
            }.map { pair ->
                shortestPathBinaryMatrix(grid, pair.first, pair.second, currentNode = currentNode + 1,
                    visitedNodes = HashSet(visitedNodes.also { it.add("${pair.first}-${pair.second}") })
                )
            }.filter { it > -1 }.minOrNull() ?: -1
        } else if (currentColumn == 0) {
            listOf(
                Pair(currentRow, currentColumn + 1),
                Pair(currentRow + 1, currentColumn + 1),
                Pair(currentRow + 1, currentColumn),
            ).filter {
                !visitedNodes.contains("${it.first}-${it.second}")
            }.map { pair ->
                shortestPathBinaryMatrix(grid, pair.first, pair.second, currentNode = currentNode + 1,
                    visitedNodes = HashSet(visitedNodes.also { it.add("${pair.first}-${pair.second}") })
                )
            }.filter { it > -1 }.minOrNull() ?: -1
        } else if (currentRow == rowCount) {
            listOf(
                Pair(currentRow - 1, currentColumn),
                Pair(currentRow - 1, currentColumn + 1),
                Pair(currentRow, currentColumn + 1),
            ).filter {
                !visitedNodes.contains("${it.first}-${it.second}")
            }.map { pair ->
                shortestPathBinaryMatrix(grid, pair.first, pair.second, currentNode = currentNode + 1,
                    visitedNodes = HashSet(visitedNodes.also { it.add("${pair.first}-${pair.second}") })
                )
            }.filter { it > -1 }.minOrNull() ?: -1
        } else if (currentColumn == columnCount) {
            listOf(
                Pair(currentRow, currentColumn - 1),
                Pair(currentRow + 1, currentColumn - 1),
                Pair(currentRow + 1, currentColumn),
            ).filter {
                !visitedNodes.contains("${it.first}-${it.second}")
            }.map { pair ->
                shortestPathBinaryMatrix(grid, pair.first, pair.second, currentNode = currentNode + 1,
                    visitedNodes = HashSet(visitedNodes.also { it.add("${pair.first}-${pair.second}") })
                )
            }.filter { it > -1 }.minOrNull() ?: -1

        } else {
            listOf(
                Pair(currentRow - 1, currentColumn - 1),
                Pair(currentRow, currentColumn - 1),
                Pair(currentRow + 1, currentColumn - 1),

                Pair(currentRow + 1, currentColumn),

                Pair(currentRow + 1, currentColumn + 1),
                Pair(currentRow, currentColumn + 1),
                Pair(currentRow - 1, currentColumn + 1),

                Pair(currentRow - 1, currentColumn),

                ).filter {
                !visitedNodes.contains("${it.first}-${it.second}")
            }.map { pair ->
                shortestPathBinaryMatrix(grid, pair.first, pair.second, currentNode = currentNode + 1,
                    visitedNodes = HashSet(visitedNodes.also { it.add("${pair.first}-${pair.second}") })
                )
            }.filter { it > -1 }.minOrNull() ?: -1
        }
    }

}


fun main() {
    val shortestPath = ShortestPath()
    shortestPath.shortestPathBinaryMatrix(
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 0),
        )
    ).let { println(it) }
    println("=-=-=-=-=")
    shortestPath.shortestPathBinaryMatrix(
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
        )
    ).let { println(it) }
    println(
        shortestPath.shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(1, 0, 0),
            )
        )
    )
    println(
        shortestPath.shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 1, 0),
            )
        )
    )
    println(
        shortestPath.shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(1, 1)
            )
        )
    )
    println(
        shortestPath.shortestPathBinaryMatrix(
            arrayOf(
                intArrayOf(0, 1, 1, 0, 0, 0),
                intArrayOf(0, 1, 0, 1, 1, 0),
                intArrayOf(0, 1, 1, 0, 1, 0),
                intArrayOf(0, 0, 0, 1, 1, 0),
                intArrayOf(1, 1, 1, 1, 1, 0),
                intArrayOf(1, 1, 1, 1, 1, 0),
            )
        )
    )
    println(
        shortestPath.shortestPathBinaryMatrix(
           arrayOf(
               intArrayOf(0, 0, 0),
               intArrayOf(1, 1, 0),
               intArrayOf(1, 1, 0),
           )
        )
    )
}
