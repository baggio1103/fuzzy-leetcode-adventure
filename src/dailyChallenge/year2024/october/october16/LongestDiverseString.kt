package dailyChallenge.year2024.october.october16

import java.util.PriorityQueue

fun main() {
    println(
        longestDiverseString(
            3, 3, 0
        )
    )
}

fun longestDiverseString(a: Int, b: Int, c: Int): String = buildString {
    val queue = PriorityQueue<Pair<Int, Char>>(
        compareByDescending { it.first }
    )
    if (a > 0) queue.add(Pair(a, 'a'))
    if (b > 0) queue.add(Pair(b, 'b'))
    if (c > 0) queue.add(Pair(c, 'c'))
    var one = 'x'
    var two = 'y'
    while (queue.isNotEmpty()) {
        val (count, char) = queue.poll()
        if (char == one && one == two) {
            if (queue.isEmpty()) break
            val (nextCount, nextChar) = queue.poll()
            one = two
            two = nextChar
            append(nextChar)
            if (nextCount - 1 > 0) queue.add(Pair(nextCount - 1, nextChar))
            queue.add(Pair(count, char))
            continue
        }
        append(char)
        one = two
        two = char
        if (count - 1 > 0) queue.add(Pair(count - 1, char))
    }
}

