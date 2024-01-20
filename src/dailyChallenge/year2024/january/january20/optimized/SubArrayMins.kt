package dailyChallenge.year2024.january.january20.optimized

import kotlin.random.Random


fun sumSubArrayMinimums(array: IntArray): Int {
    var count = 0
    val subArrays = mutableListOf<MutableList<Int>>()
    array.forEach { value ->
        count += value
        subArrays.forEach { subList ->
            subList.add(value)
        }
        subArrays.add(mutableListOf(value))
    }
    println(subArrays)
    return 1
}


fun sumSubArrayMins(array: IntArray): Int {
    val mod = 1_000_000_007
    var count = 0
    var iteration = 0
    val size = 30000
    val minimums = MutableList(size) { _ -> 0 }
    array.forEach { value ->
        count += value
        count %= mod
        for (i in 0 .. iteration) {
            val currentValue = if (value < minimums[i]) {
                minimums[i] = value
                value
            } else
                minimums[i]
            count+=currentValue
            count %= mod
        }
        iteration++
        minimums.add(value)
    }
    return count
}


fun main() {
    val array = IntArray(30000) {
        Random.nextInt(100, 100000)
    }
    println(
        sumSubArrayMins(array)
    )
    println(
        sumSubArrayMins(
            intArrayOf(3, 2, 1, 4)
        )
    )
    println(
        sumSubArrayMins(
            intArrayOf(11, 81, 94, 43, 3)
        )
    )
}