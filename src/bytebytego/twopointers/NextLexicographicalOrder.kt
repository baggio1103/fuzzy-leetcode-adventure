package bytebytego.twopointers

fun main() {
    println(nextLexicographicalSequence("dcba"))
    println(nextLexicographicalSequence("abaec"))
    println(nextLexicographicalSequence("abcedda")) // abdacde
    println(nextLexicographicalSequence("aaaa"))
    println(nextLexicographicalSequence("a"))
    println(nextLexicographicalSequence("ynitsed"))
}

fun nextLexicographicalSequence(string: String): String {
    val letters = string.toCharArray()
    var pivot = letters.size - 2
    // find pivot
    while (pivot >= 0 && letters[pivot] >= letters[pivot + 1]) {
        pivot--
    }
    if (pivot == -1) {
        letters.reverse()
        return letters.concatToString()
    }

    // find the right most successor
    var rightMostSuccessor = letters.size - 1
    while (letters[rightMostSuccessor] <= letters[pivot]) {
        rightMostSuccessor--
    }

    var temp = letters[pivot]
    letters[pivot] = letters[rightMostSuccessor]
    letters[rightMostSuccessor] = temp
    var left = pivot + 1
    var right = letters.size - 1
    while (left < right) {
        temp = letters[left]
        letters[left] = letters[right]
        letters[right] = temp
        left++
        right--
    }
    return letters.concatToString()
}
