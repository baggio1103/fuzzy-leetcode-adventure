package dynamicprogramming

fun gridTraveler(
    rows: Int,
    columns: Int,
    rowIndex: Int = 1,
    columnIndex: Int = 1,
    memo: MutableMap<String, Long> = mutableMapOf()
): Long {
    val key = "$rowIndex:$columnIndex"
    val memoizedValue = memo[key]
    if (memoizedValue != null) {
        return memoizedValue
    }
    if (rowIndex > rows || columnIndex > columns) {
        return 0
    }
    if (rowIndex == rows && columnIndex == columns) {
        return 1
    }
    val down = gridTraveler(rows, columns, rowIndex + 1, columnIndex, memo)
    val right = gridTraveler(rows, columns, rowIndex, columnIndex + 1, memo)
    memo[key] = down + right
    return down + right
}

fun main() {
    println(
        gridTraveler(2, 3)
    )
    println(
        gridTraveler(1, 1)
    )
    println(
        gridTraveler(3, 3)
    )
    println(
        gridTraveler(18, 18)
    )
}