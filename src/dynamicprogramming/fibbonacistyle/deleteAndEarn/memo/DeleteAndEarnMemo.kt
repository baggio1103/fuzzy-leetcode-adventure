package dynamicprogramming.fibbonacistyle.deleteAndEarn.memo

import dynamicprogramming.fibbonacistyle.deleteAndEarn.deleteAndEarnMemo
import kotlin.random.Random
import kotlin.system.measureTimeMillis


fun deleteAndEarn(numbers: IntArray): Int {
    val list = numbers.asList()
    val deleteAndEarn = deleteAndEarn(list, 1)
    return deleteAndEarn
}

fun deleteAndEarn(numbers: List<Int>, currentIndex: Int = 0): Int {
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
        return currentValue
    }
    return List(remainingElements.size) { index ->
        currentValue + deleteAndEarn(remainingElements, index)
    }.max()
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
        "Exec time: ${
            measureTimeMillis {
                println(
                    deleteAndEarnMemo(
                        IntArray(19) {
                            Random.nextInt(0, 1000)
                        }
                    )
                )
            }
        } ms"
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