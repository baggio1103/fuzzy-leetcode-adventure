package dailyChallenge.year2025.november.november26

import java.util.Stack

fun main() {
    println(
        gridTraveler(3, 7)
    )
    println(
        stackGridTraveler(3, 7)
    )
    println(
        stackGridTraveler(2, 3)
    )
}


fun gridTraveler(row: Int, column: Int, cache: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()): Int {
    if (row == 0 || column == 0) return 0
    if (row == 1 && column == 1) return 1
    val key = row to column
    if (key in cache) return cache.getValue(key)
    cache[key] = gridTraveler(row - 1, column, cache) + gridTraveler(row, column - 1, cache)
    return cache.getValue(key)
}

fun gridTraveler(
    i: Int, j: Int,
    row: Int = 0,
    column: Int = 0,
    cache: MutableMap<String, Int> = mutableMapOf()
): Int {
    val value = cache["$row-$column"]
    if (value != null) return value
    if (row == i - 1 && column == j - 1) {
        return 1
    }
    if (row >= i || column >= j) {
        return 0
    }
    // down
    val down = gridTraveler(i, j, row + 1, column, cache)
    cache["${row + 1}-$column"] = down
    // right
    val right = gridTraveler(i, j, row, column + 1, cache)
    cache["${row}-${column + 1}"] = right
    return down + right
}

fun stackGridTraveler(row: Int, column: Int): Int {
    val stack = Stack<Pair<Int, Int>>().apply { push(0 to 0) }
    var count = 0
    while (stack.isNotEmpty()) {
        val (i, j) = stack.peek()
        if (i >= row || j >= column) {
            stack.pop()
            continue
        }
        if (i == row - 1 && j == column - 1) {
            count++
            stack.pop()
            continue
        }
        stack.pop()
        stack.push(i + 1 to j)
        stack.push(i to j + 1)
    }
    return count
}
