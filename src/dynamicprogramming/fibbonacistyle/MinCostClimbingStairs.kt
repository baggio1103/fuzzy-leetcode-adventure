package dynamicprogramming.fibbonacistyle

import kotlin.math.min

class MinCostClimbingStairs {

    fun minCostClimbingStairs(
        stairCosts: IntArray,
        index: Int = -1,
        map: MutableMap<Int, Int> = mutableMapOf()
    ): Int {
        if (map.containsKey(index)) {
            return map[index] ?: throw IllegalArgumentException("Value cannot be null")
        }
        if (index >= stairCosts.size) {
            return 0
        }
        val left = minCostClimbingStairs(stairCosts, index + 1, map)
        val right = minCostClimbingStairs(stairCosts, index + 2, map)
        val value = min(left, right) + if (index != -1) stairCosts[index] else 0
        map[index] = value
        return value
    }

}

fun main() {
    val minCostClimbingStairs = MinCostClimbingStairs()
    println(
        minCostClimbingStairs.minCostClimbingStairs(intArrayOf(10, 15, 1, 2, 25, 30))
    )
    println(
        minCostClimbingStairs.minCostClimbingStairs(intArrayOf(10, 15, 20), -1)
    )
    println(
        minCostClimbingStairs.minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1), -1)
    )
}