package dailyChallenge.year2024.january.january15

fun findWinners(matches: Array<IntArray>): List<List<Int>> {
    val winners = mutableListOf<Int>()
    val losers = mutableListOf<Int>()
    val winnersAndLosersMap = mutableMapOf<String, Int>()
    val players = hashSetOf<Int>()
    matches.forEach { match ->
        val (winner, loser) = Pair(match[0], match[1])
        players.add(winner)
        players.add(loser)
        val (winnerKey, loserKey) = Pair("w-$winner", "l-$loser")
        winnersAndLosersMap[winnerKey] = 1
        val loserCount = winnersAndLosersMap[loserKey] ?: 0
        winnersAndLosersMap[loserKey] = loserCount + 1
    }
    players.forEach { player ->
        if (!winnersAndLosersMap.containsKey("l-$player")) {
            winners.add(player)
            return@forEach
        }
        val loserValue = winnersAndLosersMap["l-$player"] ?: 0
        if (loserValue == 1) {
            losers.add(player)
        }
    }
    return listOf(winners.sorted(), losers.sorted())
}

fun main() {
    println(
        findWinners(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 6),
                intArrayOf(5, 6),
                intArrayOf(5, 7),
                intArrayOf(4, 5),
                intArrayOf(4, 8),
                intArrayOf(4, 9),
                intArrayOf(10, 4),
                intArrayOf(10, 9),
            )
        )
    )
}