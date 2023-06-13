package dailyChallenge.june.june11

import kotlin.math.max

class SnapshotArray(length: Int) {

    private val snapMap = mutableMapOf<String, Int>()

    private val snapIndexMap = IntArray(length) {
        it
    }.associateWith { mutableListOf(0) }

    private var snapCount = 0

    private val keyConstructor = { snapId: Int, index: Int ->
        "$snapId->$index"
    }

    fun set(index: Int, `val`: Int) {
        snapMap[keyConstructor(snapCount, index)] = `val`
        snapIndexMap[index]?.let {
            if (it[it.lastIndex] != snapCount) {
                it.add(snapCount)
            }
        }
    }

    fun snap(): Int {
        snapCount++
        return snapCount - 1
    }

    fun get(index: Int, snapId: Int): Int {
        return snapMap[keyConstructor(snapId, index)] ?: run {
            if (snapIndexMap[index] == null) {
                return 0
            }
            snapIndexMap[index]?.let {
                val snapIndex = max(0, binarySearch(it, snapId))
                snapMap[keyConstructor(it[snapIndex], index)]
            } ?: 0
        }
    }

    private fun binarySearch(array: MutableList<Int>, value: Int): Int {
        var start = 0
        var end = array.lastIndex
        while (start <= end) {
            val middle = start + (end - start) / 2
            if (array[middle] == value) {
                return middle
            }
            if (array[middle] > value) {
                end = middle - 1
            }
            if (array[middle] < value) {
                start = middle + 1
            }
        }
        return start - 1
    }

}

fun main() {
    val snapShot = SnapshotArray(1)
    snapShot.snap()
    snapShot.set(0, 11111)
    snapShot.snap()
    snapShot.snap()
    snapShot.set(0, 2)
    snapShot.snap()
    snapShot.snap()
    snapShot.set(0, 10)
    snapShot.snap()
    snapShot.set(0, 20)
    snapShot.snap()
    snapShot.set(0, 25)
    snapShot.snap()
    snapShot.set(0, 35)
    snapShot.snap()
    snapShot.snap()
    snapShot.snap()
    snapShot.set(0, 315)

    println(
        snapShot.get(0, 4)
    )
    println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=")
    val snap = SnapshotArray(2)
    snap.snap()
    println(
        snap.get(1, 0)
    )
    println(
        snap.get(0, 0)
    )
    snap.set(1, 8)
    println(snap.get(1, 0))
    snap.set(0, 20)
    println(snap.get(0, 0))
    snap.set(0, 7)
}