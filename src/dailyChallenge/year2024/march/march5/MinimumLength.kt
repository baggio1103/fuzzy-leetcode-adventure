package dailyChallenge.year2024.march.march5

import java.util.ArrayDeque

fun minimumLength(string: String): Int {
    var i = 0
    var j = 1
    val deque = ArrayDeque<Pair<Char, Int>>()
    while (i < string.length && j < string.length) {
        if (string[i] == string[j]) {
            j++
            continue
        }
        if (string[i] != string[j]) {
            deque.push(Pair(string[i], j - i))
            i = j
        }
    }
    deque.push(Pair(string[i], j - i))
    println(deque)
    while (deque.isNotEmpty()) {
        if (deque.size == 1) {
            val (_, count) = deque.poll()
            return if (count == 1) 1 else 0
        }
        val (prefixChar, _) = deque.peekFirst()
        val (suffixChar, _) = deque.peekLast()
        if (prefixChar == suffixChar) {
            deque.pollFirst()
            deque.pollLast()
        } else break
    }
    if (deque.isEmpty()) {
        return 0
    }
    return deque.sumOf { it.second }
}


fun main() {
    println(
        minimumLength("ccca")
    )
    println(
        minimumLength("cabaabac")
    )
    println(
        minimumLength("aabccabba")
    )

}