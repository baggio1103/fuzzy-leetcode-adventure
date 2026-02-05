package bytebytego.prefixsum

fun main() {
    println(productExceptSelf(intArrayOf(2, 3, 1, 4, 5)).contentToString())
}

fun productExceptSelf(arr: IntArray): IntArray {
    val result = IntArray(arr.size)
    var prefixProduct = 1
    for ((i, value) in arr.withIndex()) {
        result[i] = prefixProduct
        prefixProduct *= value
    }
    var suffixProduct = 1
    for (i in arr.lastIndex downTo 0) {
        result[i] *= suffixProduct
        suffixProduct *= arr[i]
    }
    return result
}