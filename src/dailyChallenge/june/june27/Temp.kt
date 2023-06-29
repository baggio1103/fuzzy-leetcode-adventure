package dailyChallenge.june.june27

fun temp(arrayOne: IntArray, arrayTwo: IntArray, k: Int): List<List<Int>> {
    val rangeMap = arrayOne.mapIndexed { index, _ ->
        Pair(index, Range(0, arrayTwo.size))
    }.toMap()
    val maxPairs = arrayOne.size * arrayTwo.size
    val list = mutableListOf<List<Int>>()
    for (i in arrayOne.indices) {
        val range = rangeMap[i]!!
        if (i  == arrayOne.lastIndex) {
            for (j in range.start until range.finish) {
//                println("${arrayOne[i]} - ${arrayTwo[j]}")
                list.add(listOf(arrayOne[i], arrayTwo[j]))
                if (list.size == k || list.size == maxPairs) {
                    return list
                }
            }
            break
        }
        for (j in range.start until  range.finish) {
            val sum = arrayOne[i] + arrayTwo[j]
            if (j == 0) {
//                println("${arrayOne[i]} - ${arrayTwo[j]}")
                list.add(listOf(arrayOne[i], arrayTwo[j]))
                if (list.size == k || list.size == maxPairs) {
                    return list
                }
                continue
            }
            val nextRange = rangeMap[i + 1]!!
            val nextSum = arrayOne[i + 1] + arrayTwo[nextRange.start]
            if (sum < nextSum) {
//                println("${arrayOne[i]} - ${arrayTwo[j]}")
                list.add(listOf(arrayOne[i], arrayTwo[j]))
                if (list.size == k || list.size == maxPairs) {
                    return list
                }
                continue
            } else {
                for (x in i + 1 until arrayOne.size) {
                    val nextSum = arrayOne[x] + arrayTwo[j - 1]
                    if (nextSum > sum) {
                        break
                    }
//                    println("${arrayOne[x]} - ${arrayTwo[j - 1]}")
                    rangeMap[x]?.let {
                        it.start++
                    }
                    list.add(listOf(arrayOne[x], arrayTwo[j - 1]))
                    if (list.size == k || list.size == maxPairs) {
                        return list
                    }
                }
            }
//            println("${arrayOne[i]} - ${arrayTwo[j]}")
            list.add(listOf(arrayOne[i], arrayTwo[j]))
            if (list.size == k || list.size == maxPairs) {
                return list
            }
        }
    }
    return list
}