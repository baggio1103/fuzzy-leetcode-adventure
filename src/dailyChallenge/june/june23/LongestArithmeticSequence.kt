package dailyChallenge.june.june23

class LongestArithmeticSequence {

    fun longestArithmeticSeqLength(array: IntArray): Int {
        array.sort()
        println(array.asList())
        var longestArithmeticSequence = 0
        for (i in 0 .. array.lastIndex) {
            var counter = 0
            for (j in i + 1 .. array.lastIndex) {

            }
        }
        return 1
    }

}

fun main() {
    val solution = LongestArithmeticSequence()
    solution.longestArithmeticSeqLength(intArrayOf(20, 1, 15, 3, 10, 5, 8))
    val array = intArrayOf(1, 3, 5, 8, 10, 15, 20)
    var counter = 0
    var maxCounter = 0
    val diff = array[1] - array[0]
    for (i in 2 until  array.lastIndex) {
        val currentDiff = array[i] - array[i - 1]
        if (currentDiff == diff) {
            counter++
        } else {
            counter = 0
        }
    }
}