package dailyChallenge.year2024.october.october17

fun main() {
    maximumSwap(1267)


    maximumSwap(1991)

    maximumSwap(9929)
    maximumSwap(1234)
    maximumSwap(2736)
    maximumSwap(9973)
}

fun maximumSwap(num: Int): Int {
    val string = num.toString().toCharArray()
    var maxDigitIndex = -1
    var minIndex = -1
    var maxIndex = -1
    for (i in string.lastIndex downTo 0) {
        if (maxDigitIndex == -1 || string[i] > string[maxDigitIndex]) {
            maxDigitIndex = i
        } else if (string[i] < string[maxDigitIndex]) {
            minIndex = i
            maxIndex = maxDigitIndex
        }
    }
    if (minIndex != -1 && maxIndex != -1) {
        val temp = string[minIndex]
        string[minIndex] = string[maxIndex]
        string[maxIndex] = temp
    }
    var result = 0
    string.forEach {
        result = (10 * result) + it.digitToInt()
    }
    return result
}