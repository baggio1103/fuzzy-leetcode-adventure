package dailyChallenge.year2025.february.february5

fun main() {
    println(
        areAlmostEqual("bank", "kanb")
    )
}

fun areAlmostEqual(stringOne: String, stringTwo: String): Boolean {
    val swapChars = mutableListOf<Pair<Int, Char>>()
    for (i in stringOne.indices) {
        if (stringOne[i] != stringTwo[i]) {
            swapChars.add(Pair(i, stringOne[i]))
        }
        if (swapChars.size > 2) return false
    }
    if (swapChars.isEmpty()) return true
    if (swapChars.size != 2) return false

    val (i, c) = swapChars[0]
    val (j, y) = swapChars[1]
    return c == stringTwo[j] && y == stringTwo[i]
}