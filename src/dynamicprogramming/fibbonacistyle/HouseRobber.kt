package dynamicprogramming.fibbonacistyle

import kotlin.math.min

fun rob(money: IntArray): Int {
    return money.mapIndexed { index, _ -> rob(index, money) }.max()
}

fun rob(index: Int, money: IntArray, map: MutableMap<Int, Int> = mutableMapOf()): Int {
    if (map[index] != null) {
        return map[index]!!
    }
    if (index == money.lastIndex) {
        return money.last()
    }
    if (index == money.lastIndex - 1) {
        return money[money.lastIndex - 1]
    }
    if (index + 2 > money.lastIndex) {
        return 0
    }
    val range = min(index + 2, money.lastIndex)..money.lastIndex
    val list = mutableListOf<Int>()
    for (i in range) {
        val currentValue = money[index]
        val result = rob(i, money, map)
        list.add(result + currentValue)
    }
    val max = list.max()
    map[index] = max
    return max
}

fun main() {
    println(
        rob(
            intArrayOf(2, 7, 9, 3, 1)
        )
    )
    println(
        rob(
            intArrayOf(2, 1, 1, 2)
        )
    )

    println(
        rob(
            intArrayOf(1, 2, 3, 1)
        )
    )

    println(
        rob(
            intArrayOf(9, 2, 15, 7, 6, 25)
        )
    )

}