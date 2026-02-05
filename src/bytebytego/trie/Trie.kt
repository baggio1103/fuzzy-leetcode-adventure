package bytebytego.trie

class Trie {

    private val root = TrieNode()

    fun insert(word: String) {
        var node = root
        word.forEach { ch ->
            node = node.children.getOrPut(ch) { TrieNode() }
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (ch in word) {
            node = node.children[ch] ?: return false
        }
        return node.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (ch in prefix) {
            node = node.children[ch] ?: return false
        }
        return true
    }

    class TrieNode(
        var isWord: Boolean = false,
        val children: MutableMap<Char, TrieNode> = mutableMapOf()
    ) {
        override fun toString(): String {
            return "TrieNode(isWord=$isWord, children=${children.keys})"
        }
    }

}

