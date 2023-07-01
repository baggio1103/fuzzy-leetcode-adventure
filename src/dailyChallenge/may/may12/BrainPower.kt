package dailyChallenge.may12

class BrainPower {

    fun mostPoints(questions: Array<IntArray>): Long {
        val map = mutableMapOf<Int, Long>()
        questions.forEachIndexed { index, _ ->
            var currentIndex = index
            while (currentIndex < questions.size) {
                map[index] = (map[index] ?: 0) + questions[currentIndex][0]
                currentIndex += questions[currentIndex][1] + 1
            }
        }
        return map.values.maxOf { it }
    }

    fun points(questions: Array<IntArray>, current: Int = 0, next: Int): Long {
        if (current >= questions.size || next >= questions.size) {
            return 0
        }
        return 1
    }

}

fun main() {
    val brainPower = BrainPower()

    val questionsOne = arrayOf(
        intArrayOf(3, 2),
        intArrayOf(4, 3),
        intArrayOf(4, 4),
        intArrayOf(2, 5)
    )

    println(brainPower.mostPoints(questionsOne))
    val questionsTwo = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(2, 2),
        intArrayOf(3, 3),
        intArrayOf(4, 4),
        intArrayOf(5, 5),
    )

    println(brainPower.mostPoints(questionsTwo))

//    [[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]
// Output: 157

}