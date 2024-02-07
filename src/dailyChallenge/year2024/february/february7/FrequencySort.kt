package dailyChallenge.year2024.february.february7

import java.util.*
import kotlin.Comparator

fun frequencySort(string: String): String {
    val queue = PriorityQueue(Comparator.comparing<Pair<Int, Char>, Int> { it.first }.reversed()).apply {
        string.groupingBy { it }.eachCount().forEach { (char, count) ->
            add(Pair(count, char))
        }
    }
    return buildString {
        while (queue.isNotEmpty()) {
            val (count, char) = queue.poll()
            repeat(count) {
                append(char)
            }
        }
    }
}

fun main() {
    println(
        frequencySort("tree")
    )
    println(
        frequencySort("cccaaa")
    )
    println(
        frequencySort("Aabb")
    )
}