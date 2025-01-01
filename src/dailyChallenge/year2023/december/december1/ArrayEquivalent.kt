package dailyChallenge.december.december1


fun arrayStringsAreEqual(wordOne: Array<String>, wordTwo: Array<String>): Boolean {
    return wordOne.joinToString(separator = "") { it } ==
            wordTwo.joinToString(separator = "") { it }
}

fun main() {
    println(
        arrayStringsAreEqual(
            arrayOf("ab", "c"), arrayOf("abc")
        )
    )
    println(
        arrayStringsAreEqual(
            wordOne = arrayOf("abc", "d", "defg"), wordTwo = arrayOf("abcddefg")
        )
    )
}