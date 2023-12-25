package dailyChallenge.december.december25

val map = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".mapIndexed { index, char ->
//    Pair(char, index + 1)
    Pair(index + 1, char)
}.toMap()

fun numDecodings(string: String, index: Int = 0, endIndex: Int? = null): Int {
    if (index == string.lastIndex) {
        return 1
    }

    if (map[index] == null) {

    }

    return 1
}

fun numDecodings(string: String, range: IntRange): Int {

    return 1
}

fun main() {
    println(
        numDecodings("296")
    )
    val range = IntRange(0, 0)
    range.forEach {
        println("Range: $it")
    }
}
