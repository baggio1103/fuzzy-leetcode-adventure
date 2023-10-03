package dailyChallenge.may.may2

import java.math.BigInteger
import java.util.*
import kotlin.system.measureTimeMillis

class Solution {

    fun arraySign(numbers: IntArray): Int {
        var value = 1
        for (i in numbers) {
            if (i == 0) {
                return 0
            }
            if (i < 0) {
                value *= -1
            }
        }
        return when {
            value > 0 -> 1
            value < 0 -> -1
            else -> 0
        }
    }

    fun arraySignFunc(numbers: IntArray): Int {
        val value = numbers
            .map {
                if (it == 0) {
                    return 0
                }
                BigInteger.valueOf(it.toLong())
            }
            .reduce { acc, i -> acc * i }
        return when {
            value > BigInteger.ZERO -> 1
            value < BigInteger.ZERO -> -1
            else -> 0
        }
    }

}

fun main() {
    val solution = Solution()

    val numbers = intArrayOf(-1,-2,-3,-4,3,2,1)
    println(solution.arraySign(numbers))

    val arrayTwo = intArrayOf(1,5,0,2,-3)
    println(solution.arraySign(arrayTwo))

    val arrayThree = intArrayOf(-1,1,-1,1,-1)
    println(solution.arraySign(arrayThree))
    val random = Random()
    val arrayFour = List(100_000_000) {
        _ -> random.nextInt(-1000, 1000)
    }.toIntArray()

    println(
        "Optimized took ${measureTimeMillis { solution.arraySign(arrayFour) }} ms"
    )

    println(
        """
            Functional solution with saving productValue took ${measureTimeMillis { solution.arraySignFunc(arrayFour) }} ms
        """.trimIndent()
    )

}