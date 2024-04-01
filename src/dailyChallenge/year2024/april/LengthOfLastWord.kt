package dailyChallenge.year2024.april

fun lengthOfLastWord(string: String): Int {
    var index = -1
    for (i in string.indices) {
        if (string[i] == ' ' && i + 1 in string.indices && string[i + 1] != ' ') {
            index = i
        }
    }
    var length = 0
    for (i in index + 1 until string.length) {
        if (string[i] == ' ') {
            return length
        }
        length++
    }
    return length
}

fun main() {
    println(
        lengthOfLastWord(
            "Hello World"
        )
    )
    println(
        lengthOfLastWord(
            "   fly me   to   the moon  "
        )
    )
    println(
        lengthOfLastWord(
            "luffy is still joyboy"
        )
    )
}
