package bytebytego.heap

import java.util.PriorityQueue

fun main() {
    val array = intArrayOf(5, 1, 9, 4, 7, 10)
    sortKArray(array, 2)
    println(array.contentToString())
}

fun sortKArray(array: IntArray, k: Int) {
    val queue = PriorityQueue<Int>()
    for (i in 0..minOf(k, array.lastIndex)) {
        queue.add(array[i])
    }
    var index = 0
    for (i in k + 1 until array.size) {
        array[index++] = queue.poll()
        queue.add(array[i])
    }
    while (queue.isNotEmpty()) {
        array[index++] = queue.poll()
    }
}
