package dailyChallenge.year2024.january.january23

fun maxLength(array: List<String>): Int {
    array.forEach(::println)
    val words = Array(array.size) { index -> array[index] }
    for (i in array.lastIndex downTo 0) {
        if (array[i].length != array[i].toSet().size) {
            words[i] = ""
            continue
        }
        var string = array[i]
        for (j in array.lastIndex downTo i + 1) {
            val set = words[j].toSet()
            if (set.size != words[j].length) {
                continue
            }
            var contains = false
            for (ch in array[i]) {
                if (set.contains(ch)) {
                    contains = true
                    break
                }
            }
            if (contains) {
                continue
            }
            if (array[i].length + words[j].length > string.length) {
                string = array[i] + words[j]
            }
        }
        words[i] = string
    }
    words.forEach {
        println("WordSearch: $it, len: ${it.length}")
    }
    return words.maxBy { it.length }.length
}

fun main() {
    println(
        maxLength(
            listOf(
                "ogud",
                "ejipchfydrgl",
                "b",
                "kjxmzhnuoisgqvawel",
                "mizlcgdqebwuotfnk",
                "bjvkrgeozidytquchlw",
                "tzjqwumkirxeal",
                "x",
                "rkpuabmo",
                "mxndpcqzua"
            )
        )
    )
    println(
        maxLength(
            listOf("aa", "bb")
        )
    )
    println(
        maxLength(
            listOf("un", "iq", "ue")
        )
    )
    println(
        maxLength(
            listOf("cha", "r", "act", "ers")
        )
    )
    println(
        maxLength(
            listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p")
        )
    )
}