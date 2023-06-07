package slidingwindow

class MaxVowelSubstringNumber {

    private val vowels = hashSetOf('a', 'e', 'i', 'o', 'u')

    fun maxVowels(string: String, count: Int): Int {
        var max = string.substring(0, count).count { vowels.contains(it) }
        var current = max
        for (i in 1 .. string.lastIndex.minus(count - 1)) {
            if (string[i - 1] in vowels) {
                current--
            }
            if (string[i + count - 1] in vowels) {
                current++
            }
            if (current > max) {
                max = current
            }
        }
        return max
    }

}

fun main() {
    val maxVowelSubstringNumber = MaxVowelSubstringNumber()
    println(maxVowelSubstringNumber.maxVowels("abciiidef", 3))
    println(maxVowelSubstringNumber.maxVowels("aeiou", 2))
    println(maxVowelSubstringNumber.maxVowels("leetcode", 3))
}