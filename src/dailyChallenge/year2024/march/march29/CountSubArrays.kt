package dailyChallenge.year2024.march.march29

fun countSubarrays(array: IntArray, k: Int): Long {
    val max = array.max()
    var answer = 0L
    var j = 0
    var maxElements = 0
    for (i in array.indices) {
        if (array[i] == max) {
            maxElements++
        }
        while (maxElements == k) {
            if (array[j] == max) {
                maxElements--
            }
            j++
        }
        answer += j
    }
    return answer
}

fun main() {
    println(
        countSubarrays(
            intArrayOf(4, 3, 7, 10, 2, 10, 1, 6, 10, 7, 10, 10, 9, 8, 3), 3
        )
    )
}