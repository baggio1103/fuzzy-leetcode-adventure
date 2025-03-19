package dailyChallenge.year2025.march.march19

fun main() {
    println(minOperations(intArrayOf(0, 1, 1, 1, 0, 0)))
}

fun minOperations(array: IntArray): Int {
    var count = 0
    for (i in array.indices) {
        if (array[i] == 0 && i + 2 >= array.size) return -1
        if (array[i] == 0) { // flip the next 3 bits
            (i .. i + 2).forEach { array[it] = array[it] xor 1 }
            array[i] = array[i] xor 1
            array[i + 1] = array[i + 1] xor 1
            array[i + 2] = array[i + 2] xor 1
            count++
        }
    }
    return count
}

//fun minOperations(array: IntArray): Int {
//    var count = 0
//    for (i in 2 until array.size) {
//        if (array[i - 2] == 0) {
//            array[i - 2] = array[i - 2] xor 1
//            array[i - 1] = array[i - 1] xor 1
//            array[i] = array[i] xor 1
//            count++
//        }
//    }
//    return if (array.sum() == array.size) count else -1
//}