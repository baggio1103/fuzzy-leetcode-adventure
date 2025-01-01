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
    var overallMax = -1
    map.values.forEach { array ->
        val max = array[1] - array[0] - 1
        if (max > overallMax) {
            overallMax = max
        }
    }
    return overallMax
}

fun main() {
    println(
        maxLengthBetweenEqualCharacters("xabca")
    )
    println(
        maxLengthBetweenEqualCharacters("cbzxy")
    )
}