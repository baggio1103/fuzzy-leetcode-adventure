package dailyChallenge.year2024.february.february3

fun maxSumAfterPartitioning(
    array: IntArray,
    k: Int,
    index: Int = 0,
    cache: MutableMap<String, Int> = mutableMapOf()
): Int {
    if (index >= array.size) {
        return 0
    }
    val max = IntRange(index, (index + k - 1).coerceAtMost(array.lastIndex)).maxOf {
        val key = "$index-$it"
        val cached = cache[key]
        if (cached != null) {
            cached
        } else {
            val range = IntRange(index, it)
            val subArrayMax = range.maxOf { i -> array[i] }
            val result = subArrayMax * (range.last - range.first + 1) + maxSumAfterPartitioning(array, k, it + 1, cache)
            cache[key] = result
            result
        }
    }
    return max
}


fun main() {
    println(
        maxSumAfterPartitioning(
            intArrayOf(1, 5, 6, 7), 2
        )
    )
    println(
        maxSumAfterPartitioning(
            intArrayOf(1, 15, 7, 9, 2, 5, 10), 3
        )
    )
    println(
        maxSumAfterPartitioning(
            intArrayOf(1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3), 4
        )
    )
    println(
        maxSumAfterPartitioning(
            intArrayOf(20779,436849,274670,543359,569973,280711,252931,424084,361618,430777,136519,749292,933277,477067,502755,695743,413274,168693,368216,677201,198089,927218,633399,427645,317246,403380,908594,854847,157024,719715,336407,933488,599856,948361,765131,335089,522119,403981,866323,519161,109154,349141,764950,558613,692211),
            26
        )
    )
}