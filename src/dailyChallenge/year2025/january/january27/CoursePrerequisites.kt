package dailyChallenge.year2025.january.january27

fun main() {
    println(
        checkIfPrerequisite(
            3, prerequisites = arrayOf(intArrayOf(1, 2), intArrayOf(1, 0), intArrayOf(2, 0)),
            queries = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2))
        )
    )
    println(
        checkIfPrerequisiteInQuery(
            3, prerequisites = arrayOf(intArrayOf(1, 2), intArrayOf(1, 0), intArrayOf(2, 0)),
            queries = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2))
        )
    )
}

// In Query Graph Processing
fun checkIfPrerequisiteInQuery(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
    val answer = MutableList(queries.size) { false }
    val nodes = mutableMapOf<Int, MutableSet<Int>>()

    fun search(from: Int, to: Int): Boolean {
        val queue = ArrayDeque<Int>().apply { add(from) }
        val visitedNodes = mutableSetOf(from)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            val edges = nodes[node] ?: continue
            if (edges.contains(to)) return true
            edges.forEach { edge ->
                if (!visitedNodes.contains(edge)) {
                    queue.addLast(edge)
                    visitedNodes.add(edge)
                }
            }
        }
        return false
    }

    prerequisites.forEach { (preCourse, course) ->
        nodes.getOrPut(preCourse) { mutableSetOf() }.add(course)
    }
    queries.forEachIndexed { index, (preCourse, course) ->
        answer[index] = search(preCourse, course)
    }
    return answer
}



// PreProcessed Graph
fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
    val answer = MutableList(queries.size) { false }
    val nodes = mutableMapOf<Int, MutableSet<Int>>()
    val isPrerequisite = Array(numCourses) { BooleanArray(numCourses) { false } }
    fun processNodes() {
        for (i in 0 until numCourses) {
            val queue = ArrayDeque<Int>().apply { add(i) }
            while (queue.isNotEmpty()) {
                val node = queue.removeFirst()
                nodes.getOrElse(node) { mutableSetOf() }.forEach { edge ->
                    if (!isPrerequisite[i][edge]) {
                        isPrerequisite[i][edge] = true
                        queue.addLast(edge)
                    }
                }
            }
        }
    }
    prerequisites.forEach { (preCourse, course) ->
        nodes.getOrPut(preCourse) { mutableSetOf() }.add(course)
    }
    processNodes()
    queries.forEachIndexed { index, (preCourse, course) ->
        answer[index] = isPrerequisite[preCourse][course]
    }
    return answer
}