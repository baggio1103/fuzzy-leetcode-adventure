package bytebytego.backtracking

fun main() {
    println(findAllQueens(2))
    println(findAllQueensCount(2))
    println(findAllQueens(4))
    println(findAllQueensCount(4))
}

fun findAllQueens(n: Int): List<List<String>> {
    val columns = hashSetOf<Int>()
    val diagonals = hashSetOf<Int>()
    val antiDiagonals = hashSetOf<Int>()
    val result = mutableListOf<List<String>>()
    fun backtrack(row: Int, candidate: MutableList<String>) {
        if (row == n) {
            result.add(candidate.toList())
            return
        }
        for (col in 0 until n) {
            val rc = row - col
            val cr = row + col
            if (col !in columns && rc !in diagonals && cr !in antiDiagonals) {
                columns += col
                diagonals += rc
                antiDiagonals += cr
                candidate += col.toQueenPosition(n)
                backtrack(row + 1, candidate)
                columns -= col
                diagonals -= rc
                antiDiagonals -= cr
                candidate.removeLast()
            }
        }
    }
    backtrack(0, mutableListOf())
    return result
}

fun Int.toQueenPosition(n: Int): String {
    val col = this
    return buildString {
        for (i in 0 until n) {
            append(if (i == col) 'Q' else '.')
        }
    }
}

fun findAllQueensCount(n: Int): Int {
    val columns = hashSetOf<Int>()
    val diagonals = hashSetOf<Int>()
    val antiDiagonals = hashSetOf<Int>()
    var count = 0
    fun backtrack(row: Int) {
        if (row == n) {
            count++
            return
        }
        for (col in 0 until n) {
            val rc = row - col
            val cr = row + col
            if (col !in columns && rc !in diagonals && cr !in antiDiagonals) {
                columns += col
                diagonals += rc
                antiDiagonals += cr
                backtrack(row + 1)
                columns -= col
                diagonals -= rc
                antiDiagonals -= cr
            }
        }
    }
    backtrack(0)
    return count
}
