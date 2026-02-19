package bytebytego.graphs

import java.util.ArrayDeque

fun main() {
    println(ladderLength("red", "hit", listOf("red", "bed", "hat", "rod", "rad", "rat", "hit", "bad", "bat")))
    println(ladderLength("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")))
    println(ladderLength("hot", "dog", listOf("hot", "dog")))
}

fun ladderLength(start: String, end: String, wordList: List<String>): Int {
    val dictionary = wordList.toSet()
    if (end !in dictionary) return 0
    val alphabet = "abcdefghijklmnopqrstuvwxyz"
    var dist = 1
    val queue = ArrayDeque<String>()
    val visited = mutableSetOf<String>()
    queue.offer(start)
    while (queue.isNotEmpty()) {
        repeat(queue.size) {

            val word = queue.poll()
            if (word == end) return dist

            val chars = word.toCharArray()

            for (i in word.indices) {
                for (ch in alphabet) {
                    chars[i] = ch
                    val neighbor = String(chars)
                    if (neighbor in dictionary && neighbor !in visited) {
                        visited.add(neighbor)
                        queue.offer(neighbor)
                    }
                }
                chars[i] = word[i]
            }
        }
        dist++
    }
    return 0
}
