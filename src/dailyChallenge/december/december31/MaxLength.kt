package dailyChallenge.december.december31

fun maxLengthBetweenEqualCharacters(string: String): Int {
    val map = mutableMapOf<Char, IntArray>()
    string.mapIndexed { index, char ->
        val array = map[char]
        if (array != null) {
            if (index > array[1]) {
                array[1] = index
            }
            if (index < array[0]) {
                array[0]
            }
        } else {
            map[char] = IntArray(2) {
                _ -> index
            }
        }
    }
    val result = map.values.maxBy {
        val max = it[1]
        val min = it[0]
        if (min == 0) max - 1 else max - min - 1
    }
    return result[1] - result[0] - 1
}

fun main() {
    println(
        maxLengthBetweenEqualCharacters("xabca")
    )
    println(
        maxLengthBetweenEqualCharacters("cbzxy")
    )
}