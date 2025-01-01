package dailyChallenge.december.december4

import java.util.Comparator
import java.util.PriorityQueue

fun largestGoodInteger(number: String): String {
    var goodString: String? = null
    for (i in 0 until number.length - 2) {
        if (number[i] == number[i + 1] && number[i + 1] == number[i + 2]) {
            val string = "${number[i]}${number[i + 1]}${number[i + 2]}"
            if (goodString == null) {
                goodString = string
            } else
                if (goodString.toInt() < string.toInt()) {
                    goodString = string
                }
        }
    }
    return goodString ?: ""
}

fun largestGoodIntegerFunc(number: String): String {
    val goodStrings = PriorityQueue<String>(Comparator.comparing { it.toInt() })
    for (i in 0 until number.length - 2) {
        if (number[i] == number[i + 1] && number[i + 1] == number[i + 2]) {
            goodStrings.add("${number[i]}${number[i + 1]}${number[i + 2]}")
        }
    }
    return goodStrings.peek() ?: ""
}

fun main() {
    println(
        largestGoodInteger("6777133339")
    )
    println(
        largestGoodInteger("2300019")
    )
    println(
        largestGoodInteger("42352338")
    )
    println(
        largestGoodIntegerFunc("42352338")
    )
}