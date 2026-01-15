package bytebytego.twopointers

fun main() {
    println(pairSum(intArrayOf(-5, -2, 3, 4, 6), 7).contentToString())
    println(pairSum(intArrayOf(2, 2, 3), 5).contentToString())
}

fun pairSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.size - 1
    while (left < right) {
        val sum = numbers[left] + numbers[right]
        when {
            sum == target -> return intArrayOf(left, right)
            sum > target -> right--
            else -> left++
        }
    }
    return intArrayOf(left, right)
}
