package bytebytego.backtracking

fun main() {
    println(permute(intArrayOf(4, 5, 6)))
}

fun permute(array: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtrack(candidate: MutableList<Int>, cache: MutableSet<Int>) {
        if (candidate.size == array.size) {
            result.add(candidate.toList())
            return
        }
        for (value in array) {
            if (value !in cache) {
                candidate += value
                cache += value
                backtrack(candidate, cache)
                candidate -= value
                cache -= value
            }
        }
    }
    backtrack(mutableListOf(), mutableSetOf())
    return result
}
