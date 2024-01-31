package dailyChallenge.year2024.january.january31

import java.nio.file.Files
import java.util.Stack
import kotlin.io.path.Path

//fun dailyTemperatures(temperatures: IntArray): IntArray {
//    val warmerTemperatures = IntArray(temperatures.size) { _ -> 0 }
//    for (i in warmerTemperatures.indices) {
//        val days = IntRange(i, temperatures.lastIndex).firstOrNull {
//            temperatures[it] > temperatures[i]
//        } ?: 0
//        warmerTemperatures[i] = (days - i).coerceAtLeast(0)
//    }
//    return warmerTemperatures
//}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val warmerTemperatures = IntArray(temperatures.size) { _ -> 0 }
    val valueMap = mutableMapOf<Int, Stack<Int>>()
    temperatures.forEachIndexed { index, value ->
        val indices = valueMap[value] ?: Stack()
        indices.push(index)
        valueMap[value] = indices
    }
    for (i in temperatures.lastIndex downTo 0) {
        val temperature = temperatures[i]
        for (warmerTemperature in temperature + 1 .. 100) {
            val indices = valueMap[warmerTemperature] ?: continue
            if (i > indices.peek()) {
                break
            }
            if (indices.isEmpty()) {
                continue
            }
            val index = indices.pop()
            warmerTemperatures[i] = index - i
            break
        }
    }
    return warmerTemperatures
}

fun main() {
    println(
        dailyTemperatures(
            intArrayOf(
                73, 74, 75, 71, 69, 72, 76, 50
            )
        ).asList()
    )
//    val temperatures = IntArray(100000) {
//        Random.nextInt(30, 100)
//    }
//    println(
//        "Time to exec: ${
//            measureTimeMillis {
//                println(
//                    dailyTemperatures(
//                        temperatures
//                    ).asList()
//                )
//            }
//        } ms"
//    )
    println(
        Files.readAllLines(Path("temperatures.txt")).sumOf {
            it.split(",").size
        }
    )
}