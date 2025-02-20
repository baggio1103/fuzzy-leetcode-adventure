package dailyChallenge.year2025.february.february20

import kotlin.math.pow

fun main() {
    println(
        findDifferentBinaryString(arrayOf("111", "011", "001"))
    )
    println(
        findDifferentBinaryString(arrayOf("01", "10"))
    )
    println(
        findDifferentBinaryString(arrayOf("00", "01"))
    )


}

fun findDifferentBinaryString(array: Array<String>): String {
    val maxValue = 2.0.pow(array.first().length.toDouble()).toInt()
    val values = array.fold(mutableSetOf<Int>()) { set, value ->
        set.add(Integer.parseInt(value, 2))
        set
    }
    for (value in 0..maxValue) {
        if (!values.contains(value)) {
            // we can return this value
            val binary = Integer.toBinaryString(value)
            return buildString {
                repeat(array.first().length - binary.length) {
                    append(0)
                }
                append(binary)
            }
        }
    }
    return ""
}