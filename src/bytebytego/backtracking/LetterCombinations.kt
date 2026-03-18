package bytebytego.backtracking

fun main() {
    println(letterCombinations("69"))
    println(letterCombinations("2"))
}

fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) return emptyList()
    val result = mutableListOf<String>()
    val keypad = mapOf(
        2 to "abc", 3 to "def", 4 to "ghi", 5 to "jkl",
        6 to "mno", 7 to "pqrs", 8 to "tuv", 9 to "wxyz"
    )

    fun backtrack(i: Int, current: StringBuilder) {
        if (i == digits.length) {
            result.add(current.toString())
            return
        }
        val curDigit = digits[i].digitToInt()
        for (ch in keypad.getValue(curDigit)) {
            current.append(ch)
            backtrack(i + 1, current)
            current.deleteAt(current.lastIndex)
        }
    }
    backtrack(0, StringBuilder())
    return result
}
