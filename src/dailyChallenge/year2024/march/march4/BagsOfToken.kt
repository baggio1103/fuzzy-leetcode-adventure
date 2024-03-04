package dailyChallenge.year2024.march.march4

fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
    tokens.sort()
    var currentPower = power
    var count = 0
    var biggestIndex = tokens.lastIndex
    var index = 0
    while (true) {
        if (index == tokens.size || index > biggestIndex) return count
        if (currentPower >= tokens[index]) {
            currentPower -= tokens[index]
            index++
            count++
            continue
        }
        if (index != biggestIndex && count > 0) {
            currentPower += tokens[biggestIndex]
            biggestIndex--
            count--
            continue
        }
        return count
    }
}

fun main() {
//    println(
//        bagOfTokensScore(
//            intArrayOf(100),
//            50
//        )
//    )
//    println(
//        bagOfTokensScore(
//            intArrayOf(100, 200, 300, 400),
//            1000
//        )
//    )
//    println(
//        bagOfTokensScore(
//            intArrayOf(200, 100),
//            150
//        )
//    )
    println(
        bagOfTokensScore(
            intArrayOf(100, 200, 300, 400),
            200
        )
    )
//    println(
//        bagOfTokensScore(intArrayOf(), 51)
//    )
//    println(
//        bagOfTokensScore(intArrayOf(26), 51)
//    )
    println(
        bagOfTokensScore(intArrayOf(90, 59, 95, 58), 45)
    )
}