package dailyChallenge.year2024.march.march15

fun productExceptSelf(numbers: IntArray): IntArray {
    val answer = IntArray(numbers.size)
    var prefixProduct = 1
    numbers.forEachIndexed { index, value ->
        answer[index] = prefixProduct
        prefixProduct *= value
    }
    var suffixProduct = 1
    for (i in numbers.lastIndex downTo 0) {
        answer[i] *= suffixProduct
        suffixProduct *= numbers[i]
    }
    return answer
}

fun main() {
    println(
        productExceptSelf(
            intArrayOf(0, 2, 3, 4)
        ).asList()
    )
}