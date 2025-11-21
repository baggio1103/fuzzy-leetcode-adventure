package dailyChallenge.year2025.november.november18

fun main() {
    println(isOneBitCharacter(intArrayOf(1, 0, 0)))
    println(isOneBitCharacter(intArrayOf(1, 1, 1, 0)))
}

fun isOneBitCharacter(bits: IntArray): Boolean {
    var i = 0
    while (i < bits.size) {
        when {
            i == bits.lastIndex && bits[i] == 0 -> return true
            bits[i] == 0 -> i++
            else -> i += 2
        }
    }
    return false
}
