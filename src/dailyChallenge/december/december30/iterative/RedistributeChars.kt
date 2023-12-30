package dailyChallenge.december.december30.iterative

fun makeEqual(words: Array<String>): Boolean {
    val charMap = mutableMapOf<Char, Int>()
    words.forEach { word ->
        word.forEach {
            val value = charMap[it]
            if (value == null) {
                charMap[it] = 1
            } else {
                charMap[it] = value + 1
            }
        }
    }
    charMap.forEach { (_, count) ->
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