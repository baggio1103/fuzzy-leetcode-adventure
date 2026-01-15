package bytebytego.twopointers

fun main() {
    println(threeSum(intArrayOf(0, -1, 2, -3, 1)))
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}

fun threeSum(numbers: IntArray): List<List<Int>> {
    numbers.sort()
    fun pairSum(current: Int, numbers: IntArray, target: Int): List<List<Int>> {
        var left = current
        var right = numbers.size - 1
        val result = mutableListOf<List<Int>>()
        while (left < right) {
            if (left != current && numbers[left] == numbers[left - 1]) {
                left++
                continue
            }
            val sum = numbers[left] + numbers[right]
            when {
                sum == target -> {
                    result.add(listOf(numbers[current - 1], numbers[left], numbers[right]))
                    left++
                }

                sum > target -> right--
                else -> left++
            }
        }
        return result
    }

    val triplets = mutableListOf<List<Int>>()
    for ((i, a) in numbers.withIndex()) {
        if (i > 0 && a == numbers[i - 1])
            continue
        triplets.addAll(pairSum(i + 1, numbers, -a))
    }
    return triplets
}
