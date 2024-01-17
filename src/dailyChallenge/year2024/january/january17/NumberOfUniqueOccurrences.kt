package dailyChallenge.year2024.january.january17

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map = mutableMapOf<Int, Int>()
    arr.forEach {
       val count = map[it] ?: 0
        map[it] = count + 1
    }
    val set = hashSetOf<Int>()
    map.values.forEach {
        if (set.contains(it)) {
            return false
        }
        set.add(it)
    }
    return true
}

fun main() {
    println(
        uniqueOccurrences(
            intArrayOf(1,2,2,1,1,3)
        )
    )
}