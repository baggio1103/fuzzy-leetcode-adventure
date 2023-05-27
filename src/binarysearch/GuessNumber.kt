package binarysearch

fun guess(guess: Int, pickedNumber: Int): Int {
    return if (guess == pickedNumber) {
         0
    } else if (guess > pickedNumber) {
        -1
    } else {
        1
    }

}

class GuessGame {

    fun guessNumber(n: Int, pickedNumber: Int): Int {
        var begin = 1
        var end = n
        while (begin <= end) {
            val guess = begin + (end - begin) / 2
            val response = guess(guess, pickedNumber)
            if (response == 0) {
                return guess
            }
            if (response == -1) {
                end = guess - 1
            }
            if (response == 1) {
                begin = guess + 1
            }
        }
        return -1
    }

}

fun main() {
    val guessGame = GuessGame()
    println(2126753390 / 2 + 1702766719 /2)
    println(
        guessGame.guessNumber(2126753390, 1702766719)
    )
    println(
        guessGame.guessNumber(3, 3)
    )
}