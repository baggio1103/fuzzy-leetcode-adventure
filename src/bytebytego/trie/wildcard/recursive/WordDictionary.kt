package bytebytego.trie.wildcard.recursive

class WordDictionary {

    private var root = TrieNode()

    fun addWord(word: String) {
        var node = root
        for (ch in word) {
            node = node.children.getOrPut(ch) { TrieNode() }
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {

        fun search(i: Int, node: TrieNode): Boolean {
            if (i == word.length) return node.isWord
            return when (val char = word[i]) {
                '.' -> node.children.any { (_, childNode) -> search(i + 1, childNode) }
                else -> node.children[char]?.let { childNode -> search(i + 1, childNode) } ?: false
            }
        }

        return search(0, root)
    }

    class TrieNode(
        var isWord: Boolean = false,
        val children: MutableMap<Char, TrieNode> = mutableMapOf()
    ) {
        override fun toString(): String {
            return "TrieNode(children=${children.keys})"
        }
    }

}
