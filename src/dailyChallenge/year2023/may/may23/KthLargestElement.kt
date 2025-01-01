package dailyChallenge.may.may23

class KthLargest(private val k: Int, numbers: IntArray) {

    private fun descBinarySearch(array: List<Int>, value: Int, from: Int, to: Int): Int {
        var begin = from
        var end = minOf(array.lastIndex, to)
        while (begin <= end) {
            val middle = (begin + end) / 2
            if (array[middle] == value) {
                return middle
            }
            if (array[middle] > value) {
                begin = middle + 1
            }
            if (array[middle] < value) {
                end = middle - 1
            }
        }
        return begin
    }

    private val array = numbers.sortedDescending().toMutableList()

    fun add(value: Int): Int {
        if (array.isEmpty()) {
            array.add(value)
            return value
        }
        if (k > array.size) {
            val index = descBinarySearch(array, value, 0, array.lastIndex)
            array.add(index, value)
            return array[k - 1]
        }

        if (array[k - 1] >= value) {
            return array[k - 1]
        }
        val index = descBinarySearch(
            array, value, 0, k - 1
        )
        if (index == k - 1) {
            array[index] = value
            return value
        }
        for (i in k - 1 downTo index + 1) {
            array[i] = array[i - 1]
        }
        array[index] = value
        return array[k - 1]
    }

}

fun main() {
    // Test cases
    // [[1,[]],[-3],[-2],[-4],[0],[4]]
    // [[3, [1, 1]], [1, 1, 3, 3, 3, 3, 4, 4, 4]]
    // [2, [0], [-1, 1, -2, -4, 3]]
    val kthLargest = KthLargest(3, intArrayOf(8, 4, 5, 2))

    val solution = KthLargest(2, intArrayOf(0))
    intArrayOf(-1, 1, -2, -4, 3).forEach {
        println(solution.add(it))
    }

    println(
        kthLargest.add(3)
    )
    println(
        kthLargest.add(5)
    )
    println(
        kthLargest.add(10)
    )
   println(
        kthLargest.add(9)
    )
    println(
        kthLargest.add(4)
    )
}