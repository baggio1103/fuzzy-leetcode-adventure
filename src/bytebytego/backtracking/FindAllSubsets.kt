package bytebytego.backtracking

fun main() {
    println(subsets(intArrayOf(1, 2, 3)))
}

fun subsets(array: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    fun backtracking(i: Int, candidate: MutableList<Int>) {
        if (i == array.size) {
            result.add(candidate.toList())
            return
        }
        backtracking(i + 1, candidate)
        candidate += array[i]
        backtracking(i + 1, candidate)
        candidate.removeLast()
    }
    backtracking(0, mutableListOf())
    return result
}

//fun subsets(array: IntArray): List<List<Int>> {
//    val result = mutableListOf<List<Int>>()
//    fun backtracking(i: Int, candidate: MutableList<Int>) {
//        result.add(candidate.toList())
//        for (j in i until array.size) {
//            candidate.add(array[j])
//            backtracking(j + 1, candidate)
//            candidate.removeLast()
//        }
//    }
//    backtracking(0, mutableListOf())
//    return result.toList()
//}
