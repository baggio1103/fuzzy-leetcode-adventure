package dailyChallenge.december.december11

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.system.measureTimeMillis


fun findSpecialInteger(array: IntArray): Int {
    val percentage = array.size * 0.25
    val map = mutableMapOf<Int, Int>()
    array.forEach {
        if (map[it] != null) {
            map[it] = map[it]!! + 1
        } else
            map[it] = 1
    }
    var pair = Pair(-1, -1)
    map.forEach { (key, value) ->
        if (value > percentage && value > pair.second) {
            pair = Pair(key, value)
        }
    }
    return pair.first
}


fun findSpecialIntegerFunctional(array: IntArray): Int {
    val value = array.size * 0.25
    return array.asList().groupingBy { it }.eachCount()
        .filter { it.value > value }
        .firstNotNullOfOrNull { it.key } ?: 0
}

//
fun findSpecialIntegerInSorted(array: IntArray): Int {
    val percentage = (array.size * 0.25).toInt()
    return IntRange(0, array.lastIndex).first {
        array[it] == array[it + percentage]
    }.let { array[it] }
}

fun findSpecialIntegerInSortedIterative(array: IntArray): Int {
    val percentage = (array.size * 0.25).toInt()
    for (i in 0 .. array.lastIndex) {
        if (array[i] == array[i + percentage]) {
            return array[i]
        }
    }
    return -1
}


fun main() {
    val random = Random(2000)
    val array = IntArray(100000)
    repeat(100000) {
        array[it] = random.nextInt(IntRange(0, 10000))
    }
    println(
        measureTimeMillis {
            findSpecialInteger(array)
        }
    )
    println(
        measureTimeMillis {
            findSpecialIntegerFunctional(array)
        }
    )
    println(
        findSpecialIntegerInSorted(
            intArrayOf(1, 2, 2, 6, 6, 6, 6, 7, 10)
        )
    )

}