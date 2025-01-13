package dailyChallenge.year2025.january.january13

fun main() {
    println(
        minimumLength("abaacbcbb")
    )
}

fun minimumLength(string: String): Int {
    val charCount = string.groupingBy { it }.eachCount()
    var minLength = 0
    for ((_, frequency) in charCount) {
        minLength += when {
            frequency <= 2 -> frequency
            frequency % 2 == 0 -> 2
            else -> 1
        }
    }
   return minLength
}