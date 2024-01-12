package dailyChallenge.year2024.january.january12


fun halvesAreAlike(string: String): Boolean {
    val vowels = hashSetOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    val middle = string.length / 2
    return (0 until middle).count {
         vowels.contains(string[it])
    } == (middle .. string.lastIndex).count {
        vowels.contains(string[it])
    }
}


fun main() {
    println(
        halvesAreAlike(
            "book"
        )
    )
}