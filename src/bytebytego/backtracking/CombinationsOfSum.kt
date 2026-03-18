package bytebytego.backtracking

fun main() {
    println(combinationSum(intArrayOf(1, 2, 3), 4))
}

fun combinationSum(array: IntArray, target: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtrack(start: Int, sum: Int, current: MutableList<Int>) {
        if (sum == target) {
            result.add(current.toList())
            return
        }
        if (sum > target) return
        for (i in start until array.size) {
            current += array[i]
            backtrack(i, sum + array[i], current)
            current -= array[i]
        }
    }
    backtrack(0, 0, mutableListOf())
    return result
}

