package dailyChallenge.year2025.march.march16

import java.util.PriorityQueue

fun main() {
    println(repairCars(intArrayOf(4, 2, 3, 1), 10))
    println(repairCars(intArrayOf(5, 1, 8), 6))
}

fun repairCars(ranks: IntArray, cars: Int): Long {
    val rankCount = ranks.map { it.toLong() }
        .fold(mutableMapOf<Long, Long>()) { map, value ->
        map[value] = (map[value] ?: 0) + 1
        map
    }
    // time, rank, n - number of car repairs, mechanicCount
    val heap = PriorityQueue<LongArray>(compareBy { it[0] })
    rankCount.forEach { (rank, count) ->
        heap.offer(longArrayOf(rank, rank, 1, count))
    }
    var currentTime = 0L
    var repairedCards = 0L
    while (repairedCards < cars) {
        val (time, rank, carCount, mechanicCount) = heap.poll()
        repairedCards += mechanicCount
        currentTime = time
        val newCount = carCount + 1
        heap.offer(longArrayOf(rank * newCount * newCount, rank, newCount, mechanicCount))
    }
    return currentTime
}