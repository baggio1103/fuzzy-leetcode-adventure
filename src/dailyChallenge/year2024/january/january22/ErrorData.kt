package dailyChallenge.year2024.january.january22

fun findErrorNums(array: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    array.forEach {
        val count = map[it] ?: 0
        map[it] = count + 1
    }
    val result = IntArray(2)
    for (i in 1 .. array.size) {
       val count = map[i] ?: 0
        if (count == 2) {
            result[0] = i
        }
        if (count == 0) {
            result[1] = i
        }
    }
    return result
}

fun main() {
    println(
        findErrorNums(
            intArrayOf(1, 2, 2, 4)
        ).asList()
    )
    println(
        findErrorNums(
            intArrayOf(1, 1)
        ).asList()
    )
    println(
        findErrorNums(
            intArrayOf(2, 2)
        ).asList()
    )
    println(
        findErrorNums(
            intArrayOf(3, 2, 2)
        ).asList()
    )
    println(
        findErrorNums(
            intArrayOf(1, 3, 3)
        ).asList()
    )
}