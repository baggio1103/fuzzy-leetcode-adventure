package dailyChallenge.year2024.january.january13

fun minSteps(stringOne: String, stringTwo: String): Int {
    val charCountOne = stringOne.groupingBy { it }.eachCount()
    val charCountTwo = stringTwo.groupingBy { it }.eachCount()
    var count = 0
    charCountOne.forEach { (char, frequency) ->
        count += (frequency - (charCountTwo[char] ?: 0)).coerceAtLeast(0)
    }
    return count
}

fun main() {
    println(
        minSteps("bab", "aba")
    )
    println(
        minSteps("leetcode", "practice")
    )

}