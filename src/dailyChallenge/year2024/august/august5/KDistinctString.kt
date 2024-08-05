package dailyChallenge.year2024.august.august5

fun kthDistinct(arr: Array<String>, k: Int): String {
    // index, count
    val map = mutableMapOf<String, Pair<Int, Int>>()
    for ((index, string) in arr.withIndex()) {
        val pair = map[string]
        if (pair == null) {
            map[string] = Pair(index, 1)
        } else {
            map[string] = Pair(pair.first, pair.second + 1)
        }
    }
    var count = 0
    for ((key, value) in map) {
        if (value.second == 1) {
            count++
        }
        if (count == k) return key
    }
    return ""
}

fun main() {
    println(
        kthDistinct(
            arrayOf("d", "b", "c", "b", "c", "a"),
            2
        )
    )
}