package dailyChallenge.june.june6

class ArithmeticProgression {

    fun canMakeArithmeticProgression(array: IntArray): Boolean {
        array.sort()
        val difference = array[1] - array[0]
        for (i in 1 until array.lastIndex) {
            if (difference != array[i + 1] - array[i]) {
                return false
            }
        }
        return true
    }

}

fun main() {
    val arithmeticProgression = ArithmeticProgression()
    println(
        arithmeticProgression.canMakeArithmeticProgression(intArrayOf(1, 5, 3))
    )
    println(
        arithmeticProgression.canMakeArithmeticProgression(intArrayOf(1, 2, 4))
    )
}