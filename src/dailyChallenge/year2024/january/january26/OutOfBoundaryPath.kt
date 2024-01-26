package dailyChallenge.year2024.january.january26

fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    if (startRow >= m || startRow < 0) {
        return 1
    }
    if (startColumn >= n || startColumn < 0) {
        return 1
    }
    if (maxMove == 0) {
        return 0
    }
    val up = findPaths(m, n, maxMove - 1, startRow - 1, startColumn)
    val down = findPaths(m, n, maxMove - 1, startRow + 1, startColumn)
    val left = findPaths(m, n, maxMove - 1, startRow, startColumn - 1)
    val right = findPaths(m, n, maxMove - 1, startRow, startColumn + 1)
    return up + down + left + right
}

fun main() {
    println(
        findPaths(
            2, 2, 2, 0, 0
        )
    )
    println(
        findPaths(1, 3, 3, 0, 1)
    )
}