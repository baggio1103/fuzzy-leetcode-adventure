package bytebytego.hashmapsandsets

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val n = board.size
    val rows = Array(n) { mutableSetOf<Char>() }
    val columns = Array(n) { mutableSetOf<Char>() }
    val subGrids = Array(n) { mutableSetOf<Char>() }
    for (r in 0 until n) {
        for (c in 0 until n) {
            val value = board[r][c]
            if (value == '.') continue
            val i = (r / 3) * 3 + (c / 3)
            if (
                !rows[r].add(value) ||
                !columns[c].add(value) ||
                !subGrids[i].add(value)
            ) return false
        }
    }
    return true
}
