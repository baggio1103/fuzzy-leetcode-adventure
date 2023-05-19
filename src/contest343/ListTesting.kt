package contest343

import java.util.LinkedList
import kotlin.system.measureTimeMillis

fun main() {

    val arrayListTime = measureTimeMillis {
        val list = ArrayList<Int>()
        for (i in 0..1_000_000) {
            list.add(i)
        }
    }
    println("ArrayList exec time: $arrayListTime")

    val linkedListTime = measureTimeMillis {
        val list = LinkedList<Int>()
        for (i in 0..1_000_000) {
            list.add(i)
        }
    }
    println("LinkedList exec time: $linkedListTime")
}