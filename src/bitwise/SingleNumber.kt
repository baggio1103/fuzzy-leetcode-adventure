package bitwise

class SingleNumber {

    fun singleNumber(array: IntArray): Int {
        var singleValue = 0
        array.forEach { value ->
            singleValue = value xor singleValue
        }
        return singleValue
    }

}

fun main() {
    val singleNumber = SingleNumber()
    println(
        singleNumber.singleNumber(
            intArrayOf(1, 2, 3, 4, 1, 3, 4, 2, 1)
        )
    )
}