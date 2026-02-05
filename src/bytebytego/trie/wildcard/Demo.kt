package bytebytego.trie.wildcard

import bytebytego.trie.wildcard.iterative.WordDictionary
import bytebytego.trie.wildcard.recursive.WordDictionary as Dictionary

fun main() {
    run {
        val trie = WordDictionary()
        trie.addWord("band")
        trie.addWord("rat")
        require(trie.search("ra."))
        require(!trie.search("b.."))
        trie.addWord("ran")
        require(trie.search(".an"))
    }

    run {
        val trie = Dictionary()
        trie.addWord("band")
        trie.addWord("rat")
        require(trie.search("ra."))
        require(!trie.search("b.."))
        trie.addWord("ran")
        require(trie.search(".an"))
    }

    run {
        val trie = WordDictionary()
        trie.addWord("battle")
        trie.addWord("rat")
        trie.addWord("cat")
        require(trie.search("rat"))
        require(trie.search(".at"))
        require(!trie.search("..tt"))
        require(trie.search("r.."))
        require(trie.search(".attle"))
    }

    run {
        val trie = WordDictionary()
        trie.addWord("at")
        trie.addWord("and")
        trie.addWord("an")
        trie.addWord("add")

        require(!trie.search("a"))
        require(!trie.search(".at"))

        trie.addWord("bat")

        require(trie.search(".at"))
        require(trie.search("an."))

        require(!trie.search("a.d."))
        require(!trie.search("b."))
        require(trie.search("a.d"))
        require(!trie.search("."))
    }

}