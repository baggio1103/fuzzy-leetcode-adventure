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
    minHeap.addAll(graph[0] + graph[firstPerson])
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
    println(
        findAllPeople(
            7,
            arrayOf(
                intArrayOf(2, 3, 1),
                intArrayOf(3, 4, 1),
                intArrayOf(4, 5, 1),
                intArrayOf(5, 6, 1),
                intArrayOf(6, 2, 1)
            ),
            4
        )
    )
}
