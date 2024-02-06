package dailyChallenge.year2024.february.february6

fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val stringMap = mutableMapOf<Int, MutableList<MutableList<String>>>()
    for (string in strings) {
        val lists = stringMap[string.length]
        if (lists == null) {
            stringMap[string.length] = mutableListOf(mutableListOf(string))
            continue
        }
        var isAnagram = false
        for (list in lists) {
            val word = list.first()
            if (isAnagram(word, string)) {
                list.add(string)
                isAnagram = true
                continue
            }
        }
        if (!isAnagram) {
            lists.add(mutableListOf(string))
        }
    }
    return stringMap.values.flatten()
}

fun isAnagram(s: String, t: String): Boolean {
    return t.groupingBy { it }.eachCount() == s.groupingBy { it }.eachCount()
}


fun main() {
    println(
        groupAnagrams(
            arrayOf(
                "eat","tea","tan","ate","nat","bat"
            )
        )
    )
    println(
        groupAnagrams(
            arrayOf(
                "eat","tea","tan","ate","nat","bat"
            )
        )
    )

}