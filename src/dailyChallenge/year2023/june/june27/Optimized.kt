package dailyChallenge.june.june27

fun pairs(arrayOne: IntArray, arrayTwo: IntArray, k: Int) {
    val listOne = smallestPairs(arrayOne, arrayTwo, k)
    val listTwo = smallestPairs(arrayTwo, arrayOne, k)
    val finalList: MutableList<List<Int>> = MutableList(k) {
        List(2) {
            _ -> it
        }
    }
    for (i in 0 until k) {
        finalList[i] = minOf(listOne[i], listTwo[i], compareBy { it[0] + it[1] })
    }
    println(finalList)
}
fun smallestPairs(arrayOne: IntArray, arrayTwo: IntArray, k: Int): List<List<Int>> {
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

fun main() {
    println("-=--=-=-=")
    smallestPairs(
        intArrayOf(1, 4, 7),
        intArrayOf(0, 1, 2),
        3
    ).let { println(it) }
    println("-=--=-=-=")
    smallestPairs(
        intArrayOf(1, 2, 7),
        intArrayOf(1, 8, 15),
        3
    ).let { println(it) }
    println("-=--=-=-=")
    smallestPairs(
        intArrayOf(1, 2, 7),
        intArrayOf(10, 16, 20),
        3
    ).let { println(it) }
    println("-=--=-=-= LeetCode")
    smallestPairs(
        intArrayOf(1, 7, 11),
        intArrayOf(2, 4, 6),
        3
    ).let { println(it) }

    smallestPairs(
        intArrayOf(1, 1, 2),
        intArrayOf(1, 2, 3),
        3
    ).let { println(it) }

    smallestPairs(
        intArrayOf(1, 2),
        intArrayOf(3),
        3
    ).let { println(it) }

    smallestPairs(
        intArrayOf(1, 1, 2),
        intArrayOf(1, 2, 3),
        3
    ).let { println(it) }

    smallestPairs(
        intArrayOf(1,2,4,5,6),
        intArrayOf(3,5,7,9),
        20
    ).let { println(it) }

    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    pairs(
        intArrayOf(1,2,4,5,6),
        intArrayOf(3,5,7,9),
        20
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n")
    println(
        """
            [[1,3],[2,3],[1,5],[2,5],[1,7],[2,7],[5,2],[7,2],[5,4],[5,3],[6,3],[4,5],[5,5],[6,5],[4,7],[5,7],[9,2],[4,9],[5,9],[6,9]]
            [[1,3],[2,3],[1,5],[4,3],[2,5],[5,3],[1,7],[6,3],[4,5],[2,7],[5,5],[1,9],[6,5],[4,7],[2,9],[5,7],[6,7],[4,9],[5,9],[6,9]]
        """.trimIndent()
    )
}

data class Range(
    var start: Int,
    var finish: Int
)