package dailyChallenge.december.december12


fun maxProductFunctional(array: IntArray): Int {
    return array.sortedArrayDescending().take(2).let {
        (it[0] - 1) * (it[1] - 1)
    }
}

fun maxProduct(array: IntArray): Int {
    val (maxIndex, a) = array.let {
        var maxValue = array[0]
        var maxIndex = 0
        it.forEachIndexed { index, value ->
            if (value > maxValue) {
                maxValue = value
                maxIndex = index
            }
        }
        Pair(maxIndex, maxValue - 1)
    }
    return a * array.let {
        var maxValue = array[if (maxIndex == 0) 1 else 0]
        for (i in 0..it.lastIndex) {
            if (array[i] > maxValue && i != maxIndex) {
                maxValue = array[i]
            }
        }
        maxValue - 1
    }
}

fun main() {
    println(
        maxProduct(
            intArrayOf(3, 4, 5, 2)
        )
    )
    println(
        maxProduct(
            intArrayOf(
                1, 5, 4, 5
            )
        )
    )
    println(
        maxProduct(
            intArrayOf(
                3, 7
            )
        )
    )
    println(
        maxProduct(
            intArrayOf(10, 2, 5, 2)
        )
    )
}