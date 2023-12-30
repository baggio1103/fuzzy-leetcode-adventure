package dailyChallenge.december.december30

fun makeEqual(words: Array<String>): Boolean {
    val chars = words.flatMap { it.toCharArray().asIterable() }.groupingBy { it }.eachCount()
    chars.forEach { (_, count) ->
        if (count %  words.size != 0) {
            return false
        }
    }
    return true
}

fun main() {
    println(
        makeEqual(arrayOf("abc","aabc","bc"))
    )
    println(
        makeEqual(arrayOf("ab","a"))
    )

}