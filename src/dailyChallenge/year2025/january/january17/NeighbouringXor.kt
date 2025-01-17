package dailyChallenge.year2025.january.january17

fun doesValidArrayExist(derived: IntArray): Boolean {
    var result = 0
    for (value in derived) {
        result = result xor value
    }
    return result == 0
}

fun main() {
    println(
        doesValidArrayExist(derived = intArrayOf(1, 1, 0))
    )
}