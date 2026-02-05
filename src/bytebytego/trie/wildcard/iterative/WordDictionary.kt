package bytebytego.trie.wildcard.iterative

import java.util.ArrayDeque

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
        val queue = ArrayDeque<TrieNode>()
        queue.offer(root)
        var node: TrieNode
        for (ch in word) {
            val size = queue.size
            repeat(size) {
                node = queue.poll()
                if (ch == '.') {
                    node.children.forEach { (_, childNode) -> queue.offer(childNode) }
                } else {
                    if (ch in node.children) queue.offer(node.children.getValue(ch))
                }
            }
        }
        while (queue.isNotEmpty()) if (queue.poll().isWord) return true
        return false
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
