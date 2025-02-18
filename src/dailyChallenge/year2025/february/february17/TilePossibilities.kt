package dailyChallenge.year2025.february.february17

fun main() {
    println(
        numTilePossibilities("AAB")
    )
    println(numTilePossibilities("XZ"))

}

fun numTilePossibilities(tiles: String): Int {
    val charCount = IntArray(26)
    for (char in tiles.toCharArray()) {
        charCount[char.code - 'A'.code]++
    }
    return findSequences(charCount)
}

private fun findSequences(charCount: IntArray): Int {
    var totalCount = 0
    for (index in 0..25) {
        if (charCount[index] == 0) {
            continue
        }
        totalCount++
        charCount[index]--
        totalCount += findSequences(charCount)
        charCount[index]++
    }
    return totalCount
}