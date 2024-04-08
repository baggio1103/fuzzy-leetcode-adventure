package dailyChallenge.year2024.april.april8

import java.util.ArrayDeque

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    val queue = ArrayDeque<Int>()
    students.forEach { queue.offer(it) }
    var index = 0
    var queueSwitch: Int
    while (index != sandwiches.size) {
        if (queue.peek() == sandwiches[index]) {
            queue.poll()
            index++
            continue
        }
        queueSwitch = 0
        while (queue.peek() != sandwiches[index]) {
            if (queueSwitch == queue.size) return queueSwitch
            val poll = queue.poll()
            queue.offer(poll)
            queueSwitch++
        }
        queue.poll()
        index++
    }
    return 0
}

fun main() {
    println(
        countStudents(
            students = intArrayOf(1, 1, 0, 0),
            sandwiches = intArrayOf(1, 0, 1, 0)
        )
    )
    println(
        countStudents(
            students = intArrayOf(1, 1, 1, 0, 0, 1),
            sandwiches = intArrayOf(1, 0, 0, 0, 1, 1)
        )
    )
}