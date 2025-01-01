package dailyChallenge.june.june8

class CountNegativeNumberInMatrix {

    fun countNegatives(matrix: Array<IntArray>): Int {
        var count = 0
        matrix.forEach { array ->
            var i = 0
            while (i < array.size) {
                if (array[i] < 0) {
                    count = count + array.size - i
                    break
                }
                i++
            }
        }
        return count
    }

}

fun main() {
    val countNegative = CountNegativeNumberInMatrix()
    println(
        countNegative.countNegatives(
            arrayOf(
                intArrayOf(4,3,2,-1),
                intArrayOf(3,2,1,-1),
                intArrayOf(1,1,-1,-2),
                intArrayOf(-1,-1,-2,-3)
            )
        )
    )
    println(
        countNegative.countNegatives(
            arrayOf(
                intArrayOf(3, 2),
                intArrayOf(1, 0)
            )
        )
    )
}