package dailyChallenge.year2024.april.april3

fun exist(board: Array<CharArray>, word: String): Boolean {
    val rows = board.indices
    val columns = board[0].indices
    val matrix = Array(board.size) {
        IntArray(board[0].size) { 0 }
    }

    fun search(r: Int, c: Int, i: Int): Boolean {
        if (i == word.length) {
            return true
        }
        if (r !in rows || c !in columns || word[i] != board[r][c] || matrix[r][c] == 1) {
            return false
        }
        matrix[r][c] = 1
        val result = search(r + 1, c, i + 1)
                || search(r - 1, c, i + 1)
                || search(r, c - 1, i + 1)
                || search(r, c + 1, i + 1)
        matrix[r][c] = 0
        return result
    }
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (search(i, j, 0)) return true
        }
    }
    return false
}


fun main() {
    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'E', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            ),
            "ABCESEEEFS"
        )
    )

    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            ),
            "ABCCED"
        )
    )

    println(
        exist(
            arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E'),
            ),
            "ABCB"
        )
    )

    println(
        exist(
            arrayOf(
                charArrayOf('a', 'a'),
            ),
            "aaa"
        )
    )


    println(
        exist(
            arrayOf(
                charArrayOf('C', 'A', 'A'),
                charArrayOf('A', 'A', 'A'),
                charArrayOf('B', 'C', 'D'),
            ),
            "AAB"
        )
    )
}
