package dailyChallenge.year2024.april.april8.opt

fun countStudents(students: IntArray, sandwiches: IntArray): Int {
    var size = students.size
    val countMap = mutableMapOf<Int, Int>()
    students.forEach {
        val value = countMap[it] ?: 0
        countMap[it] = value + 1
    }
    sandwiches.forEach { sandwich ->
        val count = countMap[sandwich] ?: 0
        if (count > 0) {
            size--
            countMap[sandwich] = count - 1
        } else return size
    }
    return size
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