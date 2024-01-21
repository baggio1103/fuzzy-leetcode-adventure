package dailyChallenge.year2024.january.january21

fun rob(houses: IntArray): Int {
    val cache = mutableMapOf<Int, Int>()
    fun rob(houses: IntArray, index: Int): Int {
        val cached = cache[index]
        if (cached != null) {
            return cached
        }
        if (index == houses.lastIndex) {
            cache[index] = houses.last()
            return houses.last()
        }
        if (index == houses.lastIndex - 1) {
            cache[index] = houses[index]
            return houses[index]
        }
        if (index >= houses.size) {
            cache[index] = 0
            return 0
        }
        val range = index + 2..houses.lastIndex
        val value = range.maxOfOrNull { rob(houses, it) } ?: 0
        cache[index] = houses[index] + value
        return houses[index] + value
    }

    return houses.indices.maxOf { rob(houses, it) }
}

fun main() {
    println(
        rob(
            intArrayOf(1, 2, 3, 1)
        )
    )
    println(
        rob(
            intArrayOf(2, 7, 9, 3, 1)
        )
    )
}
