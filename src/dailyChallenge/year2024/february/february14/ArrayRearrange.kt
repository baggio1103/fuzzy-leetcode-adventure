package dailyChallenge.year2024.february.february14

fun rearrangeArray(array: IntArray): IntArray {
    val resultArray = IntArray(array.size) { _ -> 0 }
    var positiveIndex = 0
    var negativeIndex = 0
    var count = 0
    var index = 0
    while (count != array.size) {
        if (index % 2 == 0 && array[positiveIndex] < 0) {
            positiveIndex++
            continue
        }
        if (index % 2 == 0) {
            resultArray[index] = array[positiveIndex]
            positiveIndex++
            count++
            index++
            continue
        }
        if (array[negativeIndex] >= 0) {
            negativeIndex++
            continue
        }
        resultArray[index] = array[negativeIndex]
        negativeIndex++
        index++
        count++
    }
    return resultArray
}

fun rearrangeArray(array: Array<Int>): IntArray {
    var posIndex = 0
    var negIndex = 1
    val resultingArray = IntArray(array.size) { _ -> 0 }
    array.forEach { value ->
        if (value < 0) {
            resultingArray[negIndex] = value
            negIndex += 2
        } else {
            resultingArray[posIndex] = value
            posIndex += 2
        }
    }
    return resultingArray
}
