package dailyChallenge.may3

class Solution {

    fun findDifference(arrayOne: IntArray, arrayTwo: IntArray): List<List<Int>> {
        val answer = listOf(hashSetOf<Int>(), hashSetOf())
        val setOne = arrayOne.toHashSet()
        val setTwo = arrayTwo.toHashSet()
        arrayOne.forEach {
            if (!setTwo.contains(it)) {
                answer[0].add(it)
            }
        }
        arrayTwo.forEach {
            if (!setOne.contains(it)) {
                answer[1].add(it)
            }
        }
        return answer.map {
            it.toList()
        }
    }

}

fun main() {
    val solution = Solution()
    val arrayOne = intArrayOf(1, 2, 3)
    val arrayTwo = intArrayOf(2, 4, 6)
    println(solution.findDifference(arrayOne, arrayTwo))

    println(
        solution.findDifference(
            intArrayOf(1,2,3,3),
            intArrayOf(1,1,2,2)
        )
    )
}