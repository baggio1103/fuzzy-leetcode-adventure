package dailyChallenge.june.june9

class SmallestLetter {

    fun nextGreatestLetter(letters: CharArray, target: Char): Char {
        letters.forEach {char ->
            if (char > target) {
                return char
            }
        }
        return letters[0]
    }

}

fun main() {
    val smallestLetter = SmallestLetter()
    println(
        smallestLetter.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'a')
    )
    println(
        smallestLetter.nextGreatestLetter(charArrayOf('c', 'f', 'j'), 'c')
    )
    println(
        smallestLetter.nextGreatestLetter(charArrayOf('x', 'x', 'y', 'y'), 'z')
    )
}