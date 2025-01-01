package dailyChallenge.june.june7

import kotlin.math.log2
import kotlin.math.max
import kotlin.math.pow

class MinimumFlip {

    fun minFlips(a: Int, b: Int, c: Int): Int {
        val maxValue = max(a, max(b, c))
        val powerOfTwo = powerOfTwo(maxValue)
        val maxSize = if (log2(maxValue.toDouble()) > powerOfTwo) {
            powerOfTwo + 2
        } else {
            powerOfTwo + 1
        }
        val aBitArray = intToBinary(a, maxSize)
        val bBitArray = intToBinary(b, maxSize)
        val cBitArray = intToBinary(c, maxSize)
        var bitFlips = 0
        for (i in maxSize - 1 downTo 0) {
            val aBit = aBitArray[i]
            val bBit = bBitArray[i]
            val cBit = cBitArray[i]
            if (aBit.or(bBit) != cBit) {
                when {
                    aBit == 1 && bBit == 1 -> {
                        bitFlips+=2
                    }
                    else -> {
                        bitFlips++
                    }
                }
            }
        }
        return bitFlips
    }

    private fun intToBinary(value: Int, size: Int): IntArray {
        val pow = powerOfTwo(value)
        return if (log2(value.toDouble()) > pow.toDouble()) {
            var index = size - (pow + 2) + 1
            val bitArray = IntArray(size)
            val base = 2.0
            var currentValue = base.pow(pow).toInt()
            var adder = base.pow(pow).toInt()
            bitArray[index] = 1
            while (currentValue != value) {
                adder /= 2
                index++
                if (currentValue + adder <= value) {
                    currentValue += adder
                    bitArray[index] = 1
                }
            }
            bitArray
        } else {
            IntArray(size).also {
                it[size - pow - 1] = 1
            }
        }

    }

    private fun powerOfTwo(value: Int): Int {
        if (value == 1) {
            return 0
        }
        var power = 1
        var accumulator = 2
        while (accumulator < value) {
            accumulator *= 2
            power++
        }
        return if (accumulator == value) power else power - 1
    }

}


fun main() {
    val minimumFlip = MinimumFlip()
    println(
        minimumFlip.minFlips(2, 6, 5)
    )
    println(
        minimumFlip.minFlips(1, 2, 3)
    )

}
