package dailyChallenge.year2024.february.february22

fun findJudge(n: Int, trust: Array<IntArray>): Int {
    if (trust.isEmpty()) return -1
    val relations = trust.associate { Pair(it[0], it[1]) }
    val trustMap = trust.groupingBy { it[1] }.eachCount()
    trustMap.forEach { (key, value) ->
        if (value == n - 1 && relations[key] == null) {
            return key
        }
    }
    return -1
}

fun main() {
    println(
        findJudge(2, arrayOf())
    )
    println(
        findJudge(4,
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(1, 4),
                intArrayOf(2, 3),
                intArrayOf(1, 4),
                intArrayOf(4, 3),
            )
        )
    )
    println(
        findJudge(2, arrayOf(intArrayOf(1, 2)))
    )
    println(
        findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)))
    )
    println(
        findJudge(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 1)))
    )
}