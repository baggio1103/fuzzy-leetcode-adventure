package dynamicprogramming.fibbonacistyle

import java.lang.IllegalArgumentException
import kotlin.system.measureTimeMillis

/** Fibbonaci Sequence */
class ClimbingStairs {

    fun climbStairs(value: Int): Int {
        return step(value, 0)
    }
    fun step(value: Int, n: Int, map: MutableMap<Int, Int> = mutableMapOf()): Int {
        if (map.containsKey(n)) return map[n] ?: throw IllegalArgumentException("Value cannot be null")
        if (value == n) {
            return 1
        }
        if (value < n) {
            return 0
        }
        map[n] = step(value, n + 1, map) + step(value, n + 2, map)
        return map[n]!!
    }

    fun climbStairsIteratively(value: Int): Int {
        return when (value) {
            1 -> 1
            2 -> 2
            else -> {
                val values = mutableListOf(1, 2)
                for (i in 3..value) {
                    val lastIndex = values.lastIndex
                    values.add(values[lastIndex - 1] + values[lastIndex])
                }
                return values.last()
            }
        }
    }

}

fun main() {
    val climbingStairs = ClimbingStairs()
    println("Recursive approach...")
    println(
        "Result ${climbingStairs.climbStairs(3)}"
    )
    println(
        "Result ${climbingStairs.climbStairs(4)}"
    )
    println(
        "Result ${climbingStairs.climbStairs(5)}"
    )
    println(
        "Result ${climbingStairs.climbStairs(6)}"
    )
    println("\nIterative approach...")
    println(
        climbingStairs.climbStairsIteratively(3)
    )
    println(
        climbingStairs.climbStairsIteratively(4)
    )
    println(
        climbingStairs.climbStairsIteratively(5)
    )
    println(
        climbingStairs.climbStairsIteratively(6)
    )
    println("\nComparison...")
    val recursiveApproach = measureTimeMillis {
        println(climbingStairs.climbStairs(40))
    }
    println("Exec time of recursiveApproach(40): $recursiveApproach ms")
    val iterativeApproach = measureTimeMillis {
        println(climbingStairs.climbStairsIteratively(40))
    }
    println("Exec time of iterativeApproach(40): $iterativeApproach ms")
}