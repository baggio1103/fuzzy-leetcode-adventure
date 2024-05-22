package dailyChallenge.year2024.may.may22

fun partition(string: String): List<List<String>> {
    val result = mutableListOf<List<String>>()
    fun isPalindrome(string: String, start: Int, end: Int): Boolean {
        var i = start
        var j = end
        while (i < j) {
            if (string[i] != string[j]) return false
            i++
            j--
        }
        return true
    }

    fun partition(string: String, index: Int, path: MutableList<String>) {
        if (index == string.length) {
            result.add(path.map { it })
            return
        }
        for (i in index + 1..string.length) {
            if (isPalindrome(string, index, i - 1)) {
                path.add(string.substring(index, i))
                partition(string, i, path)
                path.removeLast()
            }
        }
    }
    partition(string, 0, mutableListOf())
    return result
}

fun main() {
    println(
        partition(
            "aab"
        )
    )
}