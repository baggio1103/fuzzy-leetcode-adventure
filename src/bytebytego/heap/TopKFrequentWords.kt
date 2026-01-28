package bytebytego.heap

import java.util.PriorityQueue

fun main() {
//    val queue = PriorityQueue(
//        compareBy<Pair<String, Int>> { (_, count) -> count }
//            .thenComparing { (word, _) -> word }
//    )
//    queue.offer("i" to 2)
//    queue.offer("love" to 2)
//    val result = mutableListOf<String>()
//    while (queue.isNotEmpty())
//        result.add(0, queue.poll().first)
//    println(result)
    println(topKFrequent(arrayOf("go", "coding", "byte", "byte", "go", "interview", "go"), 2))
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2))
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love",  "coding", "i", "leetcode"), 2))
    println(topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4))
}

fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val result = mutableListOf<String>()
    val wordsFreq = words.groupingBy { it }.eachCount()
    val queue = PriorityQueue(
        compareBy<Pair<String, Int>> { (_, count) -> count }
            .thenByDescending { (word, _) -> word }
    )
    wordsFreq.forEach { (word, freq) ->
        // add if its freq > queue.freq
        queue.offer(word to freq)
        if (queue.size > k)
            queue.poll()
    }
    while (queue.isNotEmpty()) {
        result.add(queue.poll().first)
    }
    return result.reversed()
}
