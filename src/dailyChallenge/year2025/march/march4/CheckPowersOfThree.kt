package dailyChallenge.year2025.march.march4

import kotlin.math.pow

fun main() {
    check(checkPowersOfThree(81)) // true
    check(!checkPowersOfThree(26)) // false
    check(checkPowersOfThree(28)) // true
    check(checkPowersOfThree(30)) // true
    check(checkPowersOfThree(31)) // true
    check(!checkPowersOfThree(32)) // false
    check(checkPowersOfThree(12)) // true
    check(!checkPowersOfThree(21)) // false
    check(!checkPowersOfThree(10_000_000)) // false
}
// 28, 30, 36
// 27 + 3 + 1

fun checkPowersOfThree(n: Int): Boolean {
    // calculate upper power
    val base = 3.0
    val power = (0..16).first { pow -> base.pow(pow) >= n }
    if (base.pow(power).toInt() == n) return true

    // recursively check the sum of all other powers
    fun process(target: Int, power: Int): Boolean {
        if (target == 0) return true
        if (power < 0 || target < 0) return false
        return (power downTo 0).fold(false) { acc, currentPower ->
            val newTarget = target - (base).pow(currentPower).toInt()
            val current = process(newTarget, currentPower - 1)
            acc || current
        }
    }

    return process(n, power - 1)
}