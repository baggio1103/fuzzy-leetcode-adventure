package dailyChallenge.year2024.january.january3

fun numberOfBeams(bank: Array<String>): Int {
    var beams = 0
    var i = 0
    var prevCount: Int? = null
    while (true) {
        if (i == bank.size) {
            return beams
        }
        val beamsCount = prevCount ?: bank[i].count { it == '1' }
        if (beamsCount == 0) {
            i++
            continue
        }
        var count = 1
        val index = IntRange(i + 1, bank.lastIndex).firstOrNull { index ->
            count = bank[index].count { it == '1' }
            count > 0
        } ?: -1
        if (index == -1) return beams
        beams += beamsCount * count
        i = index
        prevCount = count
    }
}

fun main() {
    println(
        numberOfBeams(
            arrayOf(
                "011001",
                "000000",
                "010100",
                "001000",
            )
        )
    )
    println(
        numberOfBeams(
            arrayOf(
                "000", "111", "000"
            )
        )
    )
}