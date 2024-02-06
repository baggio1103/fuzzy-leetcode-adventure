package dailyChallenge.year2024.february.february6.optimized

fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val stringMap = mutableMapOf<String, MutableList<String>>()
    for (string in strings) {
        val chars = string.toCharArray().sortedArray()
        val newString = String(chars)
        val list = stringMap[newString]
        if (list == null) {
            stringMap[newString] = mutableListOf(string)
            continue
        }
        stringMap[newString]?.apply { add(string) }
    }
    return stringMap.values.toList()
}

fun main() {
    println(
        groupAnagrams(
            arrayOf(
                "eat", "tea", "tan", "ate", "nat", "bat"
            )
        )
    )
}