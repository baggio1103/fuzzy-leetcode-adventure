package dailyChallenge.may.may22

class TopKFrequentElement {

    fun topKFrequent(numbers: IntArray, k: Int): IntArray {
        val mutableMap = mutableMapOf<Int, Int>()
        numbers.forEach {
            val value = mutableMap[it]
            value?.let { key ->
                mutableMap[it] = key + 1
            } ?: kotlin.run {
                mutableMap[it] = 1
            }
        }
        return mutableMap.toList().sortedByDescending { it.second }.map { it.first }.take(k).toIntArray()
    }

}

fun IntArray.info() {
    println("-=-=-=-=-=-=-=")
    this.forEach {
        print("$it ")
    }
    println("\n-=-=-=-=-=-=-=")
}

fun main() {
    val topKFrequentElement = TopKFrequentElement()

    topKFrequentElement.topKFrequent(intArrayOf(5, 5, 5, 3, 2, 5, 5, 2, 2, 3), 2).info()

    topKFrequentElement.topKFrequent(intArrayOf(1), 1).info()

    topKFrequentElement.topKFrequent(intArrayOf(-1, -1), 1).info()

}

