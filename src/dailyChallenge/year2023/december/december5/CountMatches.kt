package dailyChallenge.december.december5

fun numberOfMatches(n: Int): Int {
    var numberOfMatches = 0
    var teams = n
    while (teams != 1) {
        val matches = teams / 2
        numberOfMatches += matches
        teams -= matches
    }
    return numberOfMatches
}

fun main() {
    println(
        numberOfMatches(7)
    )
    println(
        numberOfMatches(14)
    )
}