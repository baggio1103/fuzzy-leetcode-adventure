package bytebytego.backtracking

fun main() {
    println(
        findWords(
            board = arrayOf(
                charArrayOf('b', 'y', 's'),
                charArrayOf('r', 't', 'e'),
                charArrayOf('a', 'i', 'n'),
            ),
            words = arrayOf(
                "byte", "bytes", "train", "trait", "rain"
            )
        )
    )
    println(
        findWords(
            board = arrayOf(charArrayOf('a')),
            words = arrayOf("a")
        )
    )
    println(
        findWords(
            board = arrayOf(charArrayOf('a', 'a')),
            words = arrayOf("aaa")
        )
    )
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val n = board.size
    val m = board[0].size
    val result = mutableListOf<String>()
    // construct
    val root = TrieNode()
    for (word in words) {
        var node = root
        for (ch in word) {
            node = node.children.getOrPut(ch) { TrieNode() }
        }
        node.word = word
    }
    fun backtracking(i: Int, j: Int, node: TrieNode) {
        val word = node.word
        if (word != null) {
            result.add(word)
            node.word = null
        }
        val ch = board[i][j]
        board[i][j] = '#'
        for ((x, y) in listOf(i - 1 to j, i + 1 to j, i to j - 1, i to j + 1)) {
            if (
                (x in 0 until n && y in 0 until m)
                && board[x][y] in node.children
            ) backtracking(x, y, node.children.getValue(board[x][y]))
        }
        board[i][j] = ch
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            val ch = board[i][j]
            if (ch in root.children) {
                board[i][j] = '#'
                backtracking(i, j, root.children.getValue(ch))
                board[i][j] = ch
            }
        }
    }
    return result
}

class TrieNode(
    var word: String? = null,
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
)
