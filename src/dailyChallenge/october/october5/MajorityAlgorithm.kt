package dailyChallenge.october.october5

class MajorityAlgorithm {

    fun majorityElement(array: IntArray): List<Int> {
        return array.asIterable().groupingBy { it }
            .eachCount()
            .filter { it.value > array.size / 3 }
            .map { it.key }
    }

}

fun main() {
    val majorityAlgorithm = MajorityAlgorithm()
    println(
        majorityAlgorithm.majorityElement(
            intArrayOf(3,2,3)
        )
    )
}