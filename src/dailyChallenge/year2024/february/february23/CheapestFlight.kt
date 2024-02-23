package dailyChallenge.year2024.february.february23

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
    val flightMap = mutableMapOf<Int, MutableList<List<Int>>>()
    flights.forEach {
        val list = flightMap[it[0]] ?: mutableListOf()
        list.add(it.asList())
        flightMap[it[0]] = list
    }
    fun traverse(src: Int, dst: Int, cost: Int, k: Int): Int {
        if (src == dst) {
            return cost
        }
        if (k < 0) {
            return -1
        }
        val fls = flightMap[src] ?: return -1
        val results = fls.map {
            val value = traverse(it[1], dst, it[2], k - 1)
            if (value == -1) -1 else value + cost
        }
        return results.filter { it != -1 }.minOrNull() ?: -1
    }
    return traverse(src, dst, 0, k)
}

fun main() {
    println(
        findCheapestPrice(
            5,
            arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(1, 2, 5),
                intArrayOf(0, 3, 2),
                intArrayOf(3, 1, 2),
                intArrayOf(1, 4, 1),
                intArrayOf(4, 2, 1),
            ),
            0, 2, 2,
        )
    )


    println(
        findCheapestPrice(
            4,
            arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 200),
                intArrayOf(2, 0, 100),
                intArrayOf(1, 3, 600),
                intArrayOf(2, 3, 200)
            ),
            0,
            3,
            1
        )
    )
    println(
        findCheapestPrice(
            3,
            arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 100),
                intArrayOf(0, 2, 500),
            ),
            0,
            2,
            1
        )
    )
    println(
        findCheapestPrice(
            3,
            arrayOf(
                intArrayOf(0, 1, 100),
                intArrayOf(1, 2, 100),
                intArrayOf(0, 2, 500),
            ),
            0,
            2,
            0
        )
    )
}