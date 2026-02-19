package bytebytego.graphs

import java.util.ArrayDeque

fun main() {
    require(canFinish(2, arrayOf(intArrayOf(1, 0))))
    require(!canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    require(
        canFinish(
            5, arrayOf(
                intArrayOf(1, 4),
                intArrayOf(2, 4),
                intArrayOf(3, 1),
                intArrayOf(3, 2),
            )
        )
    )

    require(
        !canFinish(
            3, arrayOf(
                intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(2, 0)
            )
        )
    )

}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val inDegree = IntArray(numCourses)
    val graph = mutableMapOf<Int, MutableList<Int>>()
    for ((prerequisite, course) in prerequisites) {
        graph.getOrPut(prerequisite) { mutableListOf() }.add(course)
        inDegree[course]++
    }
    val queue = ArrayDeque<Int>()
    for ((index, course) in inDegree.withIndex()) {
        if (course == 0) queue.offer(index)
    }
    var enrolledCourses = 0
    while (queue.isNotEmpty()) {
        val prerequisite = queue.poll()
        enrolledCourses++
        for (course in graph[prerequisite] ?: emptyList()) {
            inDegree[course]--
            if (inDegree[course] == 0) queue.offer(course)
        }
    }
    return enrolledCourses == numCourses
}
