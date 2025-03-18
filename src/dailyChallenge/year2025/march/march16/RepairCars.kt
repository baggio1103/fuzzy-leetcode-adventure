package dailyChallenge.year2025.march.march16

import java.util.PriorityQueue
import kotlin.math.sqrt

fun main() {
//    println(RepairCarsHeap.repairCars(intArrayOf(4, 2, 3, 1), 10))
//    println(RepairCarsHeap.repairCars(intArrayOf(5, 1, 8), 6))
//
//    println(RepairCarsBinarySearch.repairCars(intArrayOf(4, 2, 3, 1), 10))
//    println(RepairCarsBinarySearch.repairCars(intArrayOf(5, 1, 8), 6))

//    println(RepairCarsBinarySearch.repairCars(array, 292126)) // 1065800

//    println(RepairCarsBinarySearch.repairCars(arrayTwo, 736185))

    val arr = IntArray(100000) { 1 }
    println(RepairCarsBinarySearch.repairCars(arr, 1000000))
}

object RepairCarsHeap {

    fun repairCars(ranks: IntArray, cars: Int): Long {
        val mechanicCountMap = ranks.map { it.toLong() }
            .fold(mutableMapOf<Long, Long>()) { map, value ->
                map[value] = (map[value] ?: 0) + 1
                map
            }
        val heap = PriorityQueue<LongArray>(compareBy { it[0] })
        mechanicCountMap.forEach { (rank, count) ->
            heap.offer(longArrayOf(rank, rank, 1, count))
        }
        var repairedCars = 0L
        var repairTime = 0L
        while (repairedCars < cars) {
            val (time, rank, count, mechanicCount) = heap.poll()
            repairTime = time
            repairedCars += (mechanicCount * 1)
            val n = count + 1
            heap.offer(longArrayOf(rank * n * n, rank, n, mechanicCount))
        }
        return repairTime
    }

}

object RepairCarsBinarySearch {

    fun repairCars(ranks: IntArray, cars: Int): Long {
        val mechanicCountMap = ranks.fold(mutableMapOf<Int, Int>()) { map, value ->
            map[value] = (map[value] ?: 0) + 1
            map
        }
        val fastestMechanic = ranks.min().toLong()
        var low: Long = 1
        var high: Long = fastestMechanic * cars * cars
        while (low < high) {
            val middle = (low + high) / 2
            var count = 0L
            mechanicCountMap.forEach { (rank, mechanicCount) ->
                val amount = sqrt((middle / rank).toDouble()).toLong()
                count += amount * mechanicCount
            }
            if (count >= cars) high = middle else low = middle + 1
        }
        return low
    }

}