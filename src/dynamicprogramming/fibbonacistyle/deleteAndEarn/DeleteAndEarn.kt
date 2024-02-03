package dynamicprogramming.fibbonacistyle.deleteAndEarn

import kotlin.system.measureTimeMillis

fun deleteAndEarn(numbers: IntArray): Int {
    val list = numbers.asList()
    val memo = mutableMapOf<Pair<Int, List<Int>>, Int>()
    val result = List(list.size) { index ->
        deleteAndEarn(list, index, memo)
    }
    return result.max()
}

fun deleteAndEarn(
    numbers: List<Int>,
    currentIndex: Int = 0,
    memo: MutableMap<Pair<Int, List<Int>>, Int> = mutableMapOf()
): Int {
    val key = Pair(currentIndex, numbers)
    val memoizedValue = memo[key]
    if (memoizedValue != null) {
        return memoizedValue
    }
    if (numbers.isEmpty()) {
        return 0
    }
    if (numbers.size == 1) {
        return numbers.first()
    }
    val currentValue = numbers[currentIndex]
    val remainingElements = numbers.filterIndexed { index, value ->
        value != currentValue - 1 && value != currentValue + 1 && index != currentIndex
    }
    if (remainingElements.isEmpty()) {
        memo[key] = currentValue
        return currentValue
    }

    return List(remainingElements.size) { index ->
        val subKey = Pair(index, remainingElements)
        val subMemoizedValue = memo[subKey]
        if (subMemoizedValue != null) {
            subMemoizedValue
        } else {
            val result = deleteAndEarn(remainingElements, index, memo)
            memo[subKey] = result
            result + currentValue
        }
    }.max().also {
        memo[key] = it
    }

}

fun main() {
    println(
        deleteAndEarn(
            intArrayOf(2, 3, 4)
        )
    )
    println(
        deleteAndEarn(
            intArrayOf(1, 2, 3, 4, 5)
        )
    )
    println(
        deleteAndEarn(
            intArrayOf(2, 2, 3, 3, 3, 4)
        )
    )
    println(
        deleteAndEarn(
            intArrayOf(
                1,
                8,
                5,
                9,
                6,
                9,
                4,
                1,
                7,
                3,
                3,
                6,
                3,
                3,
                8,
                2,
                6,
                3,
                2,
                2,
                1,
                2,
                9,
                8,
                7,
                1,
                1,
                10,
                6,
                7,
                3,
                9,
                6,
                10,
                5,
                4,
                10,
                1,
                6,
                7,
                4,
                7,
                4,
                1,
                9,
                5,
                1,
                5,
                7,
                5
            )
        )
    )
    println(
        "Exec time: ${
            measureTimeMillis {
                println(
                    deleteAndEarn(
                        intArrayOf(8, 3, 4, 7, 6, 6, 9, 2, 5, 8, 2, 4, 9, 5, 9, 1, 5, 7, 1, 4)
                    )
                )
            }
        } ms"
    )
}