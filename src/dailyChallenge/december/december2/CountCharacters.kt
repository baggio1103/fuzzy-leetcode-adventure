package dailyChallenge.december.december2


// words = ["cat","bt","hat","tree"], chars = "atach"

fun countCharacters(words: Array<String>, chars: String): Int {
    val charMap = chars.groupingBy { it }.eachCount()
    return words.filter { word ->
        word.groupingBy { it }.eachCount()
            .forEach {
            val (key, value) = it
            if (charMap[key] == null || value > (charMap[key] ?: 0)) {
                return@filter false
            }
        }
        return@filter true
    }.sumOf { it.length }
}

fun main() {
    println(
        countCharacters(words = arrayOf("cat", "bt", "hat", "tree"), chars = "atach")
    )
    println(
        countCharacters(words = arrayOf("hello", "world", "leetcode"), "welldonehoneyr")
    )
}