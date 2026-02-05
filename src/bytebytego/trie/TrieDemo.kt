package bytebytego.trie

fun main() {
    val trie = Trie()
    trie.insert("top")
    trie.insert("bye")
    require(trie.startsWith("to"))
    require(!trie.search("to"))
    trie.insert("to")
    require(trie.search("to"))
}