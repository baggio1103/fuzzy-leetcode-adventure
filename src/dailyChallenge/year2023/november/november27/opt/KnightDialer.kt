package dailyChallenge.november.november27.opt

import kotlin.system.measureTimeMillis


const val mod = 1000000007

fun knightDialer(n: Int): Int {
    if (n == 1) {
        return 10
    }
    val array = IntArray(10) {
        1
    }
    var copyArray = array.copyOf()
    repeat(n - 1) {
        IntRange(0, 9).forEach { cell ->
            var accumulator = 0
            movements(cell).forEach {
                accumulator += copyArray[it]
                accumulator %= mod
            }
            array[cell] = accumulator
        }
        copyArray = array.copyOf()
    }
    var sum = 0
    array.forEach {
        sum += it
        sum %= mod
    }
    return sum
}

fun movements(cell: Int): List<Int> {
    return when (cell) {
        0 -> listOf(4, 6)
        1 -> listOf(6, 8)
        2 -> listOf(7, 9)
        3 -> listOf(4, 8)
        4 -> listOf(0, 3, 9)
        6 -> listOf(0, 1, 7)
        7 -> listOf(2, 6)
        8 -> listOf(1, 3)
        9 -> listOf(2, 4)
        else -> listOf()
    }
}


fun main() {
    println(
        knightDialer(3)
    )
    println(
        knightDialer(3131)
    )
    val execTime = measureTimeMillis {
        knightDialer(4999)
    }
    println("Exec time: $execTime")

}