package dailyChallenge.year2025.january.january31

fun main() {
    println(
        largestIsland(
            grid = arrayOf(
                intArrayOf(0, 0, 1, 0, 1),
                intArrayOf(0, 1, 0, 1, 1),
                intArrayOf(1, 0, 0, 0, 0),
                intArrayOf(1, 0, 1, 0, 0),
            )
        )
    )
    println(
        largestIsland(
            grid = arrayOf(
                intArrayOf(1, 0, 1, 0, 0),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(1, 1, 0, 1, 1),
                intArrayOf(0, 0, 1, 0, 0),
                intArrayOf(0, 0, 1, 0, 0),
            )
        )
    )
}

fun largestIsland(grid: Array<IntArray>): Int {
    val rowSize = grid.size
    val columnSize = grid[0].size
    val islandToGroup = mutableMapOf<String, String>()
    val islandGroup = mutableMapOf<String, MutableSet<String>>()
    val visited = Array(rowSize) { BooleanArray(columnSize) }

    fun search(i: Int, j: Int): Int {
        val group = "$i-$j"
        val existingGroup = islandToGroup[group]
        if (existingGroup != null && islandGroup.containsKey(existingGroup)) {
            return islandGroup.getValue(existingGroup).size
        }
        val queue = ArrayDeque<Pair<Int, Int>>().apply { add(Pair(i, j)) }
        visited[i][j] = true
        islandToGroup[group] = group
        islandGroup.getOrPut(group) { mutableSetOf() }.add(group)
        while (queue.isNotEmpty()) {
            val (row, column) = queue.removeFirst()
            listOf(
                Pair(row - 1, column), Pair(row + 1, column),
                Pair(row, column - 1), Pair(row, column + 1)
            )
                .forEach { (r, c) ->
                    if ((r in 0 until rowSize && c in 0 until columnSize)
                        && grid[r][c] == 1
                        && !visited[r][c]
                    ) {
                        queue.add(r to c)
                        val island = "$r-$c"
                        islandToGroup[island] = group
                        islandGroup[group]?.add(island)
                        visited[r][c] = true
                    }
                }
        }
        return islandGroup[group]?.size ?: 1
    }

    fun checkNeighbours(i: Int, j: Int): Int {
        val neighbours = mutableSetOf<String>()
        return listOf(i + 1 to j, i - 1 to j, i to j - 1, i to j + 1).sumOf { (r, c) ->
            val group = islandToGroup["$r-$c"]
            if (neighbours.contains(group)) {
                0
            } else {
                if (group != null) neighbours.add(group)
                islandGroup[group]?.size ?: 0
            }
        } + 1
    }

    var maxIslands = 0

    for ((i, row) in grid.withIndex()) {
        for ((j, value) in row.withIndex()) {
            if (value == 1) {
                // bfs
                val sizeOfIsland = search(i, j)
                maxIslands = maxOf(maxIslands, sizeOfIsland)
            }
        }
    }
    for ((i, row) in grid.withIndex()) {
        for ((j, value) in row.withIndex()) {
            if (value == 0) {
                // checkNeighbours(i, j)
                val islandsWithNeighbours = checkNeighbours(i, j)
                maxIslands = maxOf(maxIslands, islandsWithNeighbours)
            }
        }
    }
    return maxIslands
}