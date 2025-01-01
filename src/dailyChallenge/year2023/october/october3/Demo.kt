package dailyChallenge.october.october3

fun main() {
    val solution = Solution()
    val value = solution.numIdenticalPairs(intArrayOf(1,2,3))
    println("Result: $value")
}

class Solution {
    fun numIdenticalPairs(array: IntArray): Int {
        var counter = 0
        for (i in array.indices) {
            for (j in i + 1 until array.size) {
                if (array[i] == array[j]) {
                    counter++
                }
            }
        }
        return counter
    }
}