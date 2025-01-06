package dailyChallenge.year2025.january.january5

fun main() {
    println(
        shiftingLetters(
            string = "abxka",
            shifts = arrayOf(intArrayOf(2, 3, 1))
        )
    )
    println(
        shiftingLetters(
            string = "abxka",
            shifts = arrayOf(intArrayOf(2, 3, 1), intArrayOf(0, 2, 0), intArrayOf(1, 4, 0)),
        )
    )
    println(
        shiftingLetters(
            string = "abxka",
            shifts = arrayOf(intArrayOf(2, 3, 1), intArrayOf(0, 2, 0)),
        )
    )
}

fun shiftingLetters(string: String, shifts: Array<IntArray>): String {
    val diffArray = IntArray(string.length)
    for ((start, end, direction) in shifts) {
        if (direction == 1) {
            diffArray[start]++
            if (end + 1 < string.length) {
                diffArray[end + 1]--
            }
        } else {
            diffArray[start]--
            if (end + 1 < string.length) {
                diffArray[end + 1]++
            }
        }
    }
    val resultString = StringBuilder()
    var numberOfShifts = 0
    for ((index, diff) in diffArray.withIndex()) {
        numberOfShifts = (numberOfShifts + diff) % 26
        if (numberOfShifts < 0) numberOfShifts += 26
        val shiftedChar = ('a' + (string[index] - 'a' + numberOfShifts) % 26)
        resultString.append(shiftedChar)
    }
    return resultString.toString()
}
