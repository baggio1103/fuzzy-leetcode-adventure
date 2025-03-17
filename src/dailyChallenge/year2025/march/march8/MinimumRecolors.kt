package dailyChallenge.year2025.march.march8

fun main() {
    println(
        minimumRecolors(blocks = "WBBWWBBWBW", 7)
    )
    println(minimumRecolors(blocks = "WBWBBBW", 2))
    println(minimumRecolors(blocks = "BWWWBB", 6))
}
// WBBWWBB W B W
// BBWWBBW B W
// BWWBBWB W
// WWBBWBW

//    WBBWWBB
//    BBWWBBW
//    BWWBBWB
//    WWBBWBW

//fun minimumRecolors(blocks: String, k: Int): Int =
//    blocks.windowed(k).minOf { substring -> println(substring); substring.count { it == 'W' } }

fun minimumRecolors(blocks: String, k: Int): Int {
    var count = 0
    for (i in 0 until k) {
        if (blocks[i] == 'W') count++
    }
    var minCount = count
    for ((prev, current) in (k  until blocks.length).withIndex()) {
        val char = blocks[current]
        val prevChar = blocks[prev]
        if (char == 'B' && prevChar == 'W') if (count > 0) count--
        if (char == 'W' && prevChar == 'B') count++
        minCount = minOf(minCount, count)
    }
    return minCount
}
