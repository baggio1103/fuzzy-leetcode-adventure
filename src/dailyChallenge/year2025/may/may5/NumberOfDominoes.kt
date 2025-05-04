package dailyChallenge.year2025.may.may5

fun main() {
    println(
        numEquivDominoPairs(
            dominoes = arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 2),
                intArrayOf(3, 4),
                intArrayOf(5, 6)
            )
        )
    )
}

// [[1,2],[2,1],[3,4],[5,6]]
fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val dominoPairs = mutableMapOf<String, Int>()
    var count = 0
    for ((left, right) in dominoes) {
        val leftKeyPair = "$left-$right"
        val leftKeyPairCount = dominoPairs[leftKeyPair]
        if (leftKeyPairCount != null) {
            count += (1 * leftKeyPairCount)
            dominoPairs[leftKeyPair] = leftKeyPairCount + 1
            continue
        }
        val rightKeyPair = "$right-$left"
        val rightKeyPairCount = dominoPairs[rightKeyPair]
        if (rightKeyPairCount != null) {
            count += (1 * rightKeyPairCount)
            dominoPairs[rightKeyPair] = rightKeyPairCount + 1
            continue
        }
        dominoPairs[leftKeyPair] = 1
    }
    return count
}