package dailyChallenge.year2024.january.january14

import java.util.PriorityQueue

fun closeStrings(wordOne: String, wordTwo: String): Boolean {
    val wordOneMap = wordOne.groupingBy { it }.eachCount()
    val wordTwoMap = wordTwo.groupingBy { it }.eachCount()
    if (wordOneMap.keys != wordTwoMap.keys) {
        return false
    }
    val queueOne = PriorityQueue(wordOneMap.values)
    val queueTwo = PriorityQueue(wordTwoMap.values)
    repeat(queueOne.size) {
        if (queueOne.poll() != queueTwo.poll()) {
            return false
        }
    }
    return true
}

fun main() {
    println(
        closeStrings("abbzzca", "babzzcz")
    )
    println(
        closeStrings("a", "aa")
    )
    println(
        closeStrings("abc", "bca")
    )
    println(
        closeStrings("cabbba", "abbccc")
    )
}