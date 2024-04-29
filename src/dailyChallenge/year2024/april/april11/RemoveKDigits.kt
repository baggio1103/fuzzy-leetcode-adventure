package dailyChallenge.year2024.april.april11

import java.util.ArrayDeque

fun removeKDigits(num: String, k: Int): String {
    val queue = ArrayDeque<Char>()
    var count = k
    queue.offer(num[0])
    for (i in 1 until num.length) {
        while (queue.isNotEmpty() && queue.peek() > num[i] && count != 0) {
            queue.poll()
            count--
        }
        if (queue.isEmpty() && num[i] == '0') continue
        queue.offerFirst(num[i])
    }
    repeat(count) {
        queue.poll()
    }
    if (queue.isEmpty() || (queue.size == 1 && queue.peek() == '0')) return "0"
    return buildString {
        repeat(queue.size) {
            val ch = queue.pollLast()
            append(ch)
        }
    }
}


fun main() {
    println(
        removeKDigits(
            "1432219",
            3
        )
    )
    println(
        removeKDigits("112", 1)
    )
    println(
        removeKDigits("10200", 1)
    )
    println(
        removeKDigits(
            "10",
            2
        )
    )
    println(
        removeKDigits(
            "13057",
            3
        )
    )
    println(
        removeKDigits("100", 1)
    )
}
