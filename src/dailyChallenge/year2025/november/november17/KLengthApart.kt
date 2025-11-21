package dailyChallenge.year2025.november.november17

fun main() {
    println(kLengthApart(intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2))
    println(kLengthApart(intArrayOf(1, 0, 0, 1, 0, 1), 2))
}

//fun kLengthApart(numbers: IntArray, k: Int): Boolean {
//    val stack = Stack<Int>()
//    for ((index, value) in numbers.withIndex()) {
//        if (stack.size == 0 && value == 1) {
//            stack.push(index)
//            continue
//        }
//        if (value == 1) {
//            val prev = stack.pop()
//            if (index - prev - 1 < k) return false
//            stack.push(index)
//        }
//    }
//    return true
//}

//fun kLengthApart(numbers: IntArray, k: Int): Boolean {
//    var index = numbers.indexOfFirst { it == 1 }
//    for (i in index + 1 until numbers.size) {
//        if (numbers[i] == 1 && i - index - 1 < k) return false
//        if (numbers[i] == 1) index = i
//    }
//    return true
//}

fun kLengthApart(numbers: IntArray, k: Int): Boolean {
    var i = -1
    for ((j, value) in numbers.withIndex()) {
        if (value == 1) {
            if (i != -1 && j - i - 1 < k) return false
            i = j
        }
    }
    return true
}
