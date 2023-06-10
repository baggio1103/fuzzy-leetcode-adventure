package dailyChallenge.june.june1

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

//            listOf(
//                shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn, currentNode = currentNode + 1),
//            )
//                .filter { it > -1 }.minOrNull() ?: -1
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

//            listOf(
//                shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn, currentNode = currentNode + 1),
//            ).filter { it > -1 }.minOrNull() ?: -1
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

//            listOf(
//                shortestPathBinaryMatrix(grid, currentRow - 1, currentColumn, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow - 1, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1),
//            ).filter { it > -1 }.minOrNull() ?: -1
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

//            listOf(
//                shortestPathBinaryMatrix(grid, currentRow, currentColumn - 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn - 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn , currentNode = currentNode + 1),
//            ).filter { it > -1 }.minOrNull() ?: -1
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
//
//            listOf(
//                shortestPathBinaryMatrix(grid, currentRow - 1, currentColumn - 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow, currentColumn - 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn - 1, currentNode = currentNode + 1),
//
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn, currentNode = currentNode + 1),
//
//                shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1),
//                shortestPathBinaryMatrix(grid, currentRow - 1, currentColumn + 1, currentNode = currentNode + 1),
//
//                shortestPathBinaryMatrix(grid, currentRow - 1, currentColumn, currentNode = currentNode + 1)
//            ).filter { it > -1 }.minOrNull() ?: -1
        }
    }

}

//val right = shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1)
//val corner =
//    shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1, currentNode = currentNode + 1)
//val down = shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn, currentNode = currentNode + 1)
//when {
//    right == -1 && corner == -1 && down == -1 -> -1
//    else -> listOf(right, corner, down).filter { it > 0 }.min()
//}


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
}


fun shortestPathBinaryMatrix(
    grid: Array<IntArray>,
    currentRow: Int = 0,
    currentColumn: Int = 0,
    rowCount: Int = grid.lastIndex,
    columnCount: Int = grid[0].lastIndex,
    currentNode: Int = 1
): Int {
    if (currentRow == rowCount && currentColumn == columnCount) {
        return if (grid[rowCount][columnCount] == 0) currentNode else -1
    }
    if (grid[currentRow][currentColumn] != 0) {
        return -1
    }
    return if (currentColumn == columnCount) {
        shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn, currentNode = currentNode + 1)
    } else if (currentRow == rowCount) {
        shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1)
    } else {
        val right = shortestPathBinaryMatrix(grid, currentRow, currentColumn + 1, currentNode = currentNode + 1)
        val corner = shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn + 1, currentNode = currentNode + 1)
        val down = shortestPathBinaryMatrix(grid, currentRow + 1, currentColumn, currentNode = currentNode + 1)
        when {
            right == -1 && corner == -1 && down == -1 -> -1
            else -> listOf(right, corner, down).filter { it > 0 }.min() ?: -1
        }
    }
}

