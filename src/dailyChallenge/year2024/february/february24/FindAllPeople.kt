package dailyChallenge.year2024.february.february24

import java.util.*

fun findAllPeople(n: Int, meetings: Array<IntArray>, firstPerson: Int): List<Int> {
    val graph = Array(n) { mutableSetOf<Pair<Int, Int>>() }
    for ((x, y, time) in meetings) {
        graph[x].add(
            Pair(y, time)
        )
        graph[y].add(
            Pair(x, time)
        )
    }
    val minHeap = PriorityQueue(compareBy<Pair<Int, Int>> { it.second })
    val peopleWithSecret = mutableSetOf(0, firstPerson)
    minHeap.addAll(graph[0])
    minHeap.addAll(graph[firstPerson])

    while (minHeap.isNotEmpty()) {
        val (person, time) = minHeap.remove()
        peopleWithSecret.add(person)
        val upcomingMeetings = graph[person]
            .filter { it.second >= time }
            .filterNot { it.first in peopleWithSecret }
        minHeap.addAll(upcomingMeetings)
    }
    return peopleWithSecret.toList()
}

fun main() {
    testOne()
}

fun testOne() {
    val meetingsTwo = arrayOf(
        intArrayOf(3, 1, 3),
        intArrayOf(1, 2, 2),
        intArrayOf(0, 3, 3)
    )
    println(
        findAllPeople(
            6,
            meetingsTwo,
            3
        )
    )
}
