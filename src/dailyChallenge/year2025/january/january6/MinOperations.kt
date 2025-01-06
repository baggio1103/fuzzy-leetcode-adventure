package dailyChallenge.year2025.january.january6

fun main() {
    minOperations("110")
    minOperations("001011")
}

fun minOperations(boxes: String): IntArray {
    val resultArray = IntArray(boxes.length)
    var balls = 0
    var steps = 0
    for ((index, box) in boxes.withIndex()) {
        steps += balls
        resultArray[index] = steps
        if (box == '1') balls++
    }
    // RESET counters
    balls = 0
    steps = 0
    for (i in boxes.lastIndex downTo 0) {
        steps += balls
        resultArray[i] += steps
        if (boxes[i] == '1') balls++
    }
    return resultArray
}